package com.example.courses.features.main.courses.presentation

import androidx.lifecycle.viewModelScope
import com.example.courses.components.presentation.mvicore.BaseViewModel
import com.example.courses.components.presentation.mvicore.EventHandler
import com.example.courses.features.main.courses.domain.entity.Meta
import com.example.courses.features.main.courses.domain.usecase.GetCoursesUseCase
import com.example.courses.shared.favorite.domain.entity.Favorite
import com.example.courses.shared.favorite.domain.usecase.DeleteCourseUseCase
import com.example.courses.shared.favorite.domain.usecase.GetAllFavoritesCoursesUseCase
import com.example.courses.shared.favorite.domain.usecase.SaveCourseUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CoursesViewModel(
	private val getCoursesUseCase: GetCoursesUseCase,
	private val deleteCourseUseCase: DeleteCourseUseCase,
	private val saveFavoritesCoursesUseCase: SaveCourseUseCase,
	private val getAllFavoritesCoursesUseCase: GetAllFavoritesCoursesUseCase,
	private val router: CourseRouter,
	eventHandler: EventHandler<CoursesEvent>,
) : BaseViewModel<CoursesState, CoursesIntent>(), EventHandler<CoursesEvent> by eventHandler {

	override fun initState(): CoursesState = CoursesState(
		courses = emptyList(),
		meta = Meta(
			hasNext = false,
			hasPrevious = false,
			page = 0,
		),
		status = Status.INITIAL,
		loadingNext = false,
		loadingPrevious = false,
		coursesId = (-1),
	)

	private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
		setState(
			uiState.value.copy(
				status = Status.ERROR,
			)
		)
	}

	private val changeFavoritesExceptionHandler = CoroutineExceptionHandler { _, _ ->
		val currentState = uiState.value

		val revertedCourses = currentState.courses.map { course ->
			if (course.id == currentState.coursesId) {
				course.copy(isFavorite = !course.isFavorite)
			} else {
				course
			}
		}

		setState(
			currentState.copy(
				courses = revertedCourses
			)
		)

		// TODO SetEvent(DetailsEvent.ShowErrorSnackbar)
	}

	override fun applyIntent(intent: CoursesIntent) {
		when (intent) {
			is CoursesIntent.LoadCourses             -> handleLoadCourses()
			is CoursesIntent.LoadPreviousPage        -> handleLoadPreviousPage()
			is CoursesIntent.NavigateToDetailsScreen -> handleNavigateToDetailsScreen(intent.courseId)
			is CoursesIntent.AddFavorites            -> handleAddFavorites(intent.hasFavorites, intent.courseId)
		}
	}

	private fun handleLoadCourses() {
		val coursesState = uiState.value.copy()

		if ((!coursesState.meta.hasNext && coursesState.courses.isNotEmpty())
			|| coursesState.loadingNext
		) {
			return
		}

		setState(
			coursesState.copy(loadingNext = true)
		)

		viewModelScope.launch(exceptionHandler) {

			val coursesInfoJob = async {
				getCoursesUseCase(coursesState.meta.page + 1)
			}

			val favoritesJob = async {
				getAllFavoritesCoursesUseCase()
			}

			val coursesInfo = coursesInfoJob.await()
			val favoritesId = favoritesJob.await().map { it.id }.toSet()
			val updatedCourses = (coursesState.courses + coursesInfo.courses)
				.distinctBy { it.id }
				.map { course ->
					course.copy(isFavorite = favoritesId.contains(course.id))
				}

			setState(
				coursesState.copy(
					courses = updatedCourses,
					meta = coursesInfo.meta,
					loadingNext = false,
					status = Status.CONTENT
				),
			)
		}
	}

	private fun handleLoadPreviousPage() {
		val coursesState = uiState.value.copy()

		if ((!coursesState.meta.hasPrevious && coursesState.courses.isNotEmpty())
			|| coursesState.loadingPrevious
		) {
			return
		}

		setState(
			coursesState.copy(loadingPrevious = true)
		)

		viewModelScope.launch(exceptionHandler) {
			val coursesInfoJob = async {
				getCoursesUseCase(coursesState.meta.page - 1)
			}

			val favoritesJob = async {
				getAllFavoritesCoursesUseCase()
			}

			val favoritesId = favoritesJob.await().map { it.id }.toSet()
			val coursesInfo = coursesInfoJob.await()
			val updatedCourses = (coursesInfo.courses + coursesState.courses)
				.distinctBy { it.id }
				.map { course ->
					course.copy(isFavorite = favoritesId.contains(course.id))
				}

			setState(
				coursesState.copy(
					courses = updatedCourses,
					meta = coursesInfo.meta,
					status = Status.CONTENT,
					loadingPrevious = false
				)
			)
		}
	}

	private fun handleAddFavorites(hasFavorites: Boolean, courseId: Int) {
		val currentState = uiState.value

		val updatedCourses = currentState.courses.map { course ->
			if (course.id == courseId) {
				course.copy(isFavorite = hasFavorites)
			} else {
				course
			}
		}

		setState(
			currentState.copy(
				courses = updatedCourses
			)
		)

		viewModelScope.launch(changeFavoritesExceptionHandler) {
			if (hasFavorites) {
				saveFavoritesCoursesUseCase(
					Favorite(
						id = courseId,
						cover = updatedCourses.first { it.id == courseId }.cover,
						rank = updatedCourses.first { it.id == courseId }.rank,
						title = updatedCourses.first { it.id == courseId }.title,
						summary = updatedCourses.first { it.id == courseId }.summary,
						isPaid = updatedCourses.first { it.id == courseId }.isPaid,
						displayPrice = updatedCourses.first { it.id == courseId }.displayPrice,
						publishedDate = updatedCourses.first { it.id == courseId }.publishedDate,
					)
				)
			} else {
				deleteCourseUseCase(courseId)
			}
		}
	}

	private fun handleNavigateToDetailsScreen(courseId: Int) {
		router.navigateToDetailsScreen(courseId)
	}
}
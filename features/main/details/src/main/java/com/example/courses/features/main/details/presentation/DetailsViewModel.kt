package com.example.courses.features.main.details.presentation

import androidx.lifecycle.viewModelScope
import com.example.courses.components.presentation.mvicore.BaseViewModel
import com.example.courses.components.presentation.mvicore.EventHandler
import com.example.courses.features.main.details.domain.entity.CourseInfo
import com.example.courses.features.main.details.domain.usecase.GetDetailsUseCase
import com.example.courses.shared.favorite.domain.entity.Favorite
import com.example.courses.shared.favorite.domain.usecase.DeleteCourseUseCase
import com.example.courses.shared.favorite.domain.usecase.GetAllFavoritesCoursesUseCase
import com.example.courses.shared.favorite.domain.usecase.SaveCourseUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailsViewModel(
	private val getDetailsUseCase: GetDetailsUseCase,
	private val deleteCourseUseCase: DeleteCourseUseCase,
	private val saveFavoritesCoursesUseCase: SaveCourseUseCase,
	private val getAllFavoritesCoursesUseCase: GetAllFavoritesCoursesUseCase,
	eventHandler: EventHandler<DetailsEvent>,
	private val router: DetailsRouter,
	private val courseId: Int,
) : BaseViewModel<DetailsState, DetailsIntent>(),
	EventHandler<DetailsEvent> by eventHandler {

	private val getDetailsExceptionHandler = CoroutineExceptionHandler { _, _ ->
		setState(DetailsState.Error)
	}

	private val changeFavoritesExceptionHandler = CoroutineExceptionHandler { _, _ ->
		val currentState = uiState.value as? DetailsState.Content ?: return@CoroutineExceptionHandler

		setState(
			DetailsState.Content(
				courseInfo = currentState.courseInfo.copy(
					hasFavorites = !currentState.courseInfo.hasFavorites
				)
			)
		)

		// TODO SetEvent(DetailsEvent.ShowErrorSnachbar)
	}

	override fun initState(): DetailsState = DetailsState.Initial

	override fun applyIntent(intent: DetailsIntent) {
		when (intent) {
			is DetailsIntent.LoadCourse   -> handleLoadCourse()
			is DetailsIntent.AddFavorites -> handleAddFavorites(intent.hasFavorites)
			is DetailsIntent.NavigateBack -> handleNavigateBack()
			is DetailsIntent.OpenLink     -> handleOpenLink(intent.url)
		}
	}

	private fun handleLoadCourse() {
		setState(DetailsState.Loading)

		viewModelScope.launch(getDetailsExceptionHandler) {
			val detailsJob = async {
				getDetailsUseCase(courseId.toString())
			}

			val favoritesJob = async {
				getAllFavoritesCoursesUseCase()
			}

			val details = detailsJob.await()
			val favorites = favoritesJob.await()
			setState(
				DetailsState.Content(
					courseInfo = CourseInfo(
						id = details.id,
						cover = details.cover,
						title = details.title,
						hasFavorites = favorites.any { it.id == courseId },
						description = details.description,
						rank = details.rank,
						canonicalUrl = details.canonicalUrl,
						isPaid = details.isPaid,
						displayPrice = details.displayPrice,
						publishedDate = details.publishedDate,
						summary = details.summary,
					)
				)
			)
		}
	}

	private fun handleAddFavorites(hasFavorites: Boolean) {
		val currentState = uiState.value as? DetailsState.Content ?: return

		setState(
			DetailsState.Content(
				courseInfo = currentState.courseInfo.copy(
					hasFavorites = hasFavorites
				)
			)
		)

		viewModelScope.launch(changeFavoritesExceptionHandler) {
			if (hasFavorites) {
				saveFavoritesCoursesUseCase(
					Favorite(
						id = currentState.courseInfo.id,
						cover = currentState.courseInfo.cover,
						rank = currentState.courseInfo.rank,
						title = currentState.courseInfo.title,
						summary = currentState.courseInfo.summary,
						isPaid = currentState.courseInfo.isPaid,
						displayPrice = currentState.courseInfo.displayPrice,
						publishedDate = currentState.courseInfo.publishedDate,
					)
				)
			} else {
				deleteCourseUseCase(courseId)
			}
		}
	}

	private fun handleNavigateBack() {
		// TODO fix navigation
		router.navigateBack()
	}

	private fun handleOpenLink(url: String) {
		router.openUrl(url)
	}
}
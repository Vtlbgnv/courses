package com.example.courses.features.main.courses.presentation

import androidx.lifecycle.viewModelScope
import com.example.courses.components.presentation.mvicore.BaseViewModel
import com.example.courses.components.presentation.mvicore.EventHandler
import com.example.courses.features.main.courses.domain.entity.Meta
import com.example.courses.features.main.courses.domain.usecase.GetCoursesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CoursesViewModel(
	private val getCoursesUseCase: GetCoursesUseCase,
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
	)

	private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
		setState(
			uiState.value.copy(
				status = Status.ERROR,
			)
		)
	}

	override fun applyIntent(intent: CoursesIntent) {
		when (intent) {
			CoursesIntent.LoadCourses                -> handleLoadCourses()
			CoursesIntent.LoadPreviousPage           -> handleLoadPreviousPage()
			is CoursesIntent.NavigateToDetailsScreen -> handleNavigateToDetailsScreen(intent.courseId)
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
			val coursesInfo = getCoursesUseCase(coursesState.meta.page + 1)

			setState(
				coursesState.copy(
					courses = (coursesState.courses + coursesInfo.courses).distinctBy { it.id },
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
			val coursesInfo = getCoursesUseCase(coursesState.meta.page - 1)

			setState(
				coursesState.copy(
					courses = (coursesInfo.courses + coursesState.courses).distinctBy { it.id },
					meta = coursesInfo.meta,
					status = Status.CONTENT,
					loadingPrevious = false,
				),
			)
		}
	}

	private fun handleNavigateToDetailsScreen(courseId: Int) {
		router.navigateToDetailsScreen(courseId)
	}
}
package com.example.courses.features.userfavorites.presentation

import androidx.lifecycle.viewModelScope
import com.example.courses.components.presentation.mvicore.BaseViewModel
import com.example.courses.features.userfavorites.presentation.converter.toEntity
import com.example.courses.shared.favorite.domain.usecase.DeleteCourseUseCase
import com.example.courses.shared.favorite.domain.usecase.GetAllFavoritesCoursesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserFavoritesViewModel(
	private val getAllFavoritesCoursesUseCase: GetAllFavoritesCoursesUseCase,
	private val deleteCourseUseCase: DeleteCourseUseCase,
) : BaseViewModel<UserFavoritesState, UserFavoritesIntent>() {

	private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
		setState(UserFavoritesState.Error)
	}

	override fun initState(): UserFavoritesState = UserFavoritesState.Initial

	override fun applyIntent(intent: UserFavoritesIntent) {
		when (intent) {
			is UserFavoritesIntent.RemoveFavorites -> handleRemoveCourse(intent.id)
			is UserFavoritesIntent.LoadCourses     -> handleLoadCourses()
		}
	}

	private fun handleLoadCourses() {
		setState(UserFavoritesState.Loading)
		viewModelScope.launch(exceptionHandler) {
			setState(
				UserFavoritesState.Content(
					courses = getAllFavoritesCoursesUseCase().toEntity()
				)
			)
		}
	}

	private fun handleRemoveCourse(id: Int) {
		setState(UserFavoritesState.Loading)

		viewModelScope.launch(exceptionHandler) {
			deleteCourseUseCase(id)
			delay(200)
			setState(
				UserFavoritesState.Content(
					courses = getAllFavoritesCoursesUseCase().toEntity()
				)
			)
		}
	}
}
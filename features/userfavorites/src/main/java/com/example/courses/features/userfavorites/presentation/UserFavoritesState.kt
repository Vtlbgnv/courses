package com.example.courses.features.userfavorites.presentation

import com.example.courses.components.presentation.mvicore.State
import com.example.courses.features.userfavorites.presentation.entity.Course

interface UserFavoritesState : State {

	data object Initial : UserFavoritesState

	data object Loading : UserFavoritesState

	data class Content(
		val courses: List<Course>
	) : UserFavoritesState

	data object Error : UserFavoritesState
}
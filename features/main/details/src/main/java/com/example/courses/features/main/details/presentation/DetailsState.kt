package com.example.courses.features.main.details.presentation

import com.example.courses.components.presentation.mvicore.State

sealed interface DetailsState : State {

	data object Initial : DetailsState

	data object Loading : DetailsState

	data class Content(
		val courseInfo: com.example.courses.features.main.details.domain.entity.CourseInfo
	) : DetailsState

	data object Error : DetailsState
}
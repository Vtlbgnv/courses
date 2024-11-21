package com.example.courses.features.main.details.presentation

import com.example.courses.components.presentation.mvicore.Intent

sealed interface DetailsIntent : Intent {

	data object LoadCourse : DetailsIntent

	data class AddFavorites(val hasFavorites: Boolean) : DetailsIntent

	data class OpenLink(val url: String) : DetailsIntent

	data object NavigateBack : DetailsIntent
}
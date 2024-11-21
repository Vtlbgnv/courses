package com.example.courses.features.userfavorites.presentation

import com.example.courses.components.presentation.mvicore.Intent

interface UserFavoritesIntent : Intent {

	data object LoadCourses:UserFavoritesIntent

	data class RemoveFavorites(val id: Int) : UserFavoritesIntent

}
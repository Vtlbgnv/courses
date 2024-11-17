package com.example.courses.features.main.courses.presentation

import com.example.courses.components.presentation.mvicore.Intent

sealed interface CoursesIntent : Intent {

	data object LoadCourses : CoursesIntent

	data object LoadPreviousPage : CoursesIntent

	data class NavigateToDetailsScreen(val courseId:Int) : CoursesIntent
}
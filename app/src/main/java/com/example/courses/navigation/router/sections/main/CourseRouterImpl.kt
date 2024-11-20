package com.example.courses.navigation.router.sections.main

import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.features.main.courses.presentation.CourseRouter
import com.example.courses.features.main.details.ui.getDetailsScreen

class CourseRouterImpl(private val router: GlobalRouter) : CourseRouter {

	override fun navigateToDetailsScreen(courseId: Int) {
		router.navigateTo(getDetailsScreen(courseId))
	}
}
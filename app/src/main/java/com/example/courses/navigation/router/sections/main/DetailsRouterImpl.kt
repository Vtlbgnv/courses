package com.example.courses.navigation.router.sections.main

import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.features.main.details.presentation.DetailsRouter
import com.example.courses.navigation.router.getLinkScreen

class DetailsRouterImpl(private val router: GlobalRouter) : DetailsRouter {

	override fun navigateBack() {
		router.navigateBack()
	}

	override fun openUrl(url: String) {
		router.navigateTo(getLinkScreen(url))
	}
}
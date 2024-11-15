package com.example.courses.navigation.router.main

import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.features.mainhost.screen.getFavoritesSectionScreen
import com.example.courses.features.mainhost.screen.getMainHostScreen
import com.example.courses.features.mainhost.screen.getMainSectionScreen
import com.example.courses.features.mainhost.screen.getProfileSectionScreen
import com.example.courses.presentation.MainRouter

class MainRouterImpl(
	private val router: GlobalRouter
) : MainRouter {

	override fun navigateToMainHostScreen() {
		router.newRootScreen(getMainHostScreen())
	}

	override fun navigateToMainSection() {
		router.navigateTo(getMainSectionScreen())
	}

	override fun navigateToFavoritesSection() {
		router.navigateTo(getFavoritesSectionScreen())
	}

	override fun navigateToProfileSection() {
		router.navigateTo(getProfileSectionScreen())
	}
}
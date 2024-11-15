package com.example.courses.navigation.router.fullscreen

import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.presentation.MainHostRouter
import com.example.courses.features.mainhost.screen.getFavoritesSectionScreen
import com.example.courses.features.mainhost.screen.getMainSectionScreen
import com.example.courses.features.mainhost.screen.getProfileSectionScreen
import kotlinx.coroutines.flow.StateFlow

class MainHostRouterImpl(private val router: GlobalRouter) : MainHostRouter {

	override val currentSection: StateFlow<SectionNames?>
		get() = router.currentSection

	override fun navigateToMainSection() {
		router.navigateTo(getMainSectionScreen())
	}

	override fun navigateToFavoriteSection() {
		router.navigateTo(getFavoritesSectionScreen())
	}

	override fun navigateToProfileSection() {
		router.navigateTo(getProfileSectionScreen())
	}

	override fun navigateBack() {
		router.navigateBack()
	}
}
package com.example.courses.navigation.router.global

import com.example.courses.core.navigation.router.FullScreenRouter
import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.core.navigation.screenwrappers.FullScreen
import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.MainHostScreen
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.StateFlow

class GlobalRouterImpl(
	private val fullScreenRouter: FullScreenRouter,
	private val sectionsHostRouter: SectionsHostRouter,
) : GlobalRouter {

	override val currentSection: StateFlow<SectionNames?> = sectionsHostRouter.currentSection

	override fun newRootScreen(fragmentScreen: FragmentScreen) {
		if (fullScreenRouter.backStack.isEmpty()) {
			fullScreenRouter.newRootScreen(fragmentScreen)
			return
		}

		if (fragmentScreen !is FullScreen && fullScreenRouter.backStack.lastOrNull() is MainHostScreen) {
			sectionsHostRouter.newRootScreen(fragmentScreen)
		} else {
			fullScreenRouter.newRootScreen(fragmentScreen)
		}
	}

	override fun navigateTo(screen: Screen) {
		when (screen) {
			is FullScreen     -> {
				fullScreenRouter.navigateTo(screen)
			}

			is SectionScreen  -> {
				sectionsHostRouter.openSection(screen)
			}

			is ActivityScreen -> {
				fullScreenRouter.navigateTo(screen)
			}

			else              -> {
				sectionsHostRouter.openScreenInSection(screen)
			}
		}
	}

	override fun replace(fragmentScreen: FragmentScreen) {
		when (fragmentScreen) {
			is FullScreen     -> {
				fullScreenRouter.replace(fragmentScreen)
			}

			!is SectionScreen -> {
				sectionsHostRouter.replaceScreenInSection(fragmentScreen)
			}
		}
	}

	override fun navigateBack() {
		if (fullScreenRouter.backStack.lastOrNull() is MainHostScreen) {
			if (sectionsHostRouter.navigateBack() == SectionsHostRouter.Companion.HostStatus.EMPTY) {
				fullScreenRouter.finishChain()
			}
		} else {
			fullScreenRouter.navigateBack()
		}
	}
}
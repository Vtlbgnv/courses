package com.example.courses.navigation.router.global

import com.example.courses.core.navigation.router.SectionRouter
import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.screen.getFavoritesSectionScreen
import com.example.courses.features.mainhost.screen.getMainSectionScreen
import com.example.courses.features.mainhost.screen.getProfileSectionScreen
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SectionsHostRouter(
	private val mainHostRouter: Router,
	private val sectionRouterMap: Map<SectionNames, SectionRouter>,
) {

	companion object {

		private const val MIN_SCREEN_IN_BACK_STACK = 1

		enum class HostStatus {
			EMPTY,
			NOT_EMPTY,
		}
	}

	private val sectionBackStack = mutableListOf<SectionScreen>()

	private val _currentSection = MutableStateFlow<SectionNames?>(null)
	val currentSection = _currentSection.asStateFlow()

	fun newRootScreen(screen: FragmentScreen) {
		if (screen is SectionScreen) {
			mainHostRouter.newRootScreen(screen)
			sectionBackStack.clear()
			sectionBackStack.add(screen)
		} else {
			newRootScreenInSection(screen)
		}
	}

	private fun newRootScreenInSection(screen: FragmentScreen) {
		val currentSectionName = if (sectionBackStack.isEmpty()) {
			_currentSection.value = SectionNames.MAIN_SECTION
			SectionNames.MAIN_SECTION
		} else {
			SectionNames.valueOf(sectionBackStack.last().screenKey)
		}

		sectionRouterMap[currentSectionName]?.newRootScreen(screen)
	}

	fun openScreenInSection(screen: Screen) {
		sectionRouterMap[currentSection.value]?.navigateTo(screen)
	}

	fun replaceScreenInSection(screen: FragmentScreen) {
		sectionRouterMap[currentSection.value]?.replace(screen)
	}

	fun openSection(sectionScreen: SectionScreen) {
		val desiredSectionName = SectionNames.valueOf(sectionScreen.screenKey)
		if (desiredSectionName == currentSection.value) {
			popToRootInSection(desiredSectionName)
		} else {
			val sectionIndex = findSectionIndex(sectionScreen)
			if (sectionIndex != null && sectionIndex > 0) {
				sectionBackStack.removeAt(sectionIndex)
			}
			sectionBackStack.add(sectionScreen)
			_currentSection.value = desiredSectionName
			mainHostRouter.navigateTo(sectionScreen)
		}
	}

	private fun findSectionIndex(screen: SectionScreen): Int? =
		sectionBackStack.indexOfLast { it.screenKey == screen.screenKey }.takeIf { it >= 0 }

	private fun popToRootInSection(sectionName: SectionNames) {
		when (sectionName) {
			SectionNames.MAIN_SECTION     -> sectionRouterMap[SectionNames.MAIN_SECTION]?.newRootScreen(getMainSectionScreen())
			SectionNames.FAVORITES_SECTION -> sectionRouterMap[SectionNames.FAVORITES_SECTION]?.newRootScreen(getFavoritesSectionScreen())
			SectionNames.PROFILE_SECTION  -> sectionRouterMap[SectionNames.PROFILE_SECTION]?.newRootScreen(getProfileSectionScreen())
		}
	}

	fun navigateBack(): HostStatus {
		val backStackScreenCount =
			sectionRouterMap[currentSection.value]?.backStackScreenCount ?: throw IllegalArgumentException("Current SectionRouter is null")

		return when {
			backStackScreenCount > MIN_SCREEN_IN_BACK_STACK  -> {
				sectionRouterMap[currentSection.value]?.navigateBack()
				HostStatus.NOT_EMPTY
			}

			sectionBackStack.size > MIN_SCREEN_IN_BACK_STACK -> {
				sectionBackStack.removeLast()
				mainHostRouter.replaceScreen(sectionBackStack.last())
				_currentSection.value = SectionNames.valueOf(sectionBackStack.last().screenKey)
				HostStatus.NOT_EMPTY
			}

			else                                             -> {
				clearSections()
				HostStatus.EMPTY
			}
		}
	}

	private fun clearSections() {
		sectionRouterMap.values.forEach { it.clear() }
		_currentSection.value = null
		sectionBackStack.clear()
	}
}
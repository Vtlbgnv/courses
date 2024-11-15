package com.example.courses.core.navigation.router

import com.example.courses.core.navigation.utils.SectionNames
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.flow.StateFlow

interface GlobalRouter {

	val currentSection: StateFlow<SectionNames?>

	fun newRootScreen(fragmentScreen: FragmentScreen)

	fun navigateTo(screen: Screen)

	fun replace(fragmentScreen: FragmentScreen)

	fun navigateBack()
}
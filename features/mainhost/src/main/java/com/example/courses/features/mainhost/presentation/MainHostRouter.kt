package com.example.courses.features.mainhost.presentation

import com.example.courses.core.navigation.utils.SectionNames
import kotlinx.coroutines.flow.StateFlow

interface MainHostRouter {

	val currentSection: StateFlow<SectionNames?>

	fun navigateToMainSection()

	fun navigateToFavoriteSection()

	fun navigateToProfileSection()

	fun navigateBack()
}
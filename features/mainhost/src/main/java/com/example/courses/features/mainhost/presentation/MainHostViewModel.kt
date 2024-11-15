package com.example.courses.features.mainhost.presentation

import androidx.lifecycle.ViewModel

class MainHostViewModel(
	private val mainHostRouter: MainHostRouter,
) : ViewModel() {

	val currentSection = mainHostRouter.currentSection

	init {
		navigateToMainSection()
	}

	fun navigateToMainSection() {
		mainHostRouter.navigateToMainSection()
	}

	fun navigateToFavoriteSection() {
		mainHostRouter.navigateToFavoriteSection()
	}

	fun navigateToProfileSection() {
		mainHostRouter.navigateToProfileSection()
	}

	fun navigateBack() {
		mainHostRouter.navigateBack()
	}
}
package com.example.courses.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(
	private val router: MainRouter
) : ViewModel() {

	fun setStartScreen() {
		router.navigateToMainHostScreen()
	}
}
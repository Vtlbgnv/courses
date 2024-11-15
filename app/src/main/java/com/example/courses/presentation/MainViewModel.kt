package com.example.courses.presentation

import androidx.lifecycle.ViewModel
import com.example.courses.core.navigation.router.GlobalRouter
import com.example.courses.features.mainhost.screen.getMainHostScreen

class MainViewModel(
	private val router: GlobalRouter
) : ViewModel() {

	fun setStartScreen() {
		router.newRootScreen(getMainHostScreen())
	}
}
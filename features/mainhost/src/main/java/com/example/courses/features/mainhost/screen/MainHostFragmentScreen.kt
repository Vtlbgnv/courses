package com.example.courses.features.mainhost.screen

import com.example.courses.features.mainhost.MainHostScreen
import com.example.courses.features.mainhost.ui.MainHostFragment

fun getMainHostScreen() =
	MainHostScreen(
		key = MainHostFragment::class.java.simpleName,
		createFragment = { MainHostFragment.newInstance() }
	)
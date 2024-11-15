package com.example.courses.features.mainhost.presentation.section.viewmodel

import androidx.lifecycle.ViewModel
import com.example.courses.features.mainhost.presentation.section.NavSectionRouter

class MainSectionViewModel(
	private val navSectionRouter: NavSectionRouter,
) : ViewModel() {

	fun initRouter() {
		navSectionRouter.init()
	}
}
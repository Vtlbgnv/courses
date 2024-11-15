package com.example.courses.navigation.router.sections

import com.example.courses.core.navigation.router.SectionRouter
import com.example.courses.features.mainhost.presentation.section.NavSectionRouter

class MainNavSectionRouterImpl(private val router: SectionRouter) : NavSectionRouter {

	override var initialized = false

	override fun init() {
		if (!initialized) {
			initialized = true
			//TODO
		}
	}
}
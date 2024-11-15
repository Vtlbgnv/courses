package com.example.courses.navigation.router.sections

import com.example.courses.core.navigation.router.SectionRouter
import com.example.courses.features.mainhost.presentation.section.NavSectionRouter

class ProfileNavSectionRouterImpl(private val router: SectionRouter) : NavSectionRouter {

	override var initialized: Boolean = false

	override fun init() {
		if (!initialized) {
			initialized = true
//			TODO
		}
	}
}
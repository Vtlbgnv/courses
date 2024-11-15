package com.example.courses.features.mainhost.screen

import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.ui.section.MainSectionFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getMainSectionScreen(): FragmentScreen =
	SectionScreen(
		key = SectionNames.MAIN_SECTION.name,
		createFragment = { MainSectionFragment.newInstance() }
	)
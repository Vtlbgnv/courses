package com.example.courses.features.mainhost.screen

import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.ui.section.ProfileSectionFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getProfileSectionScreen(): FragmentScreen =
	SectionScreen(
		key = SectionNames.PROFILE_SECTION.name,
		createFragment = { ProfileSectionFragment.newInstance() },
	)
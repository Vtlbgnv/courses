package com.example.courses.features.mainhost.screen

import com.example.courses.core.navigation.screenwrappers.SectionScreen
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.ui.section.FavoritesSectionFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

fun getFavoritesSectionScreen(): FragmentScreen =
	SectionScreen(
		key = SectionNames.FAVORITES_SECTION.name,
		createFragment = { FavoritesSectionFragment.newInstance() }
	)
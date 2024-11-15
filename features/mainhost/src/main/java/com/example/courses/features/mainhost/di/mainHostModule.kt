package com.example.courses.features.mainhost.di

import com.example.courses.core.navigation.utils.RouterNames.FAVORITES_SECTION
import com.example.courses.core.navigation.utils.RouterNames.MAIN_SECTION
import com.example.courses.core.navigation.utils.RouterNames.PROFILE_SECTION
import com.example.courses.features.mainhost.presentation.MainHostViewModel
import com.example.courses.features.mainhost.presentation.section.viewmodel.FavoritesSectionViewModel
import com.example.courses.features.mainhost.presentation.section.viewmodel.MainSectionViewModel
import com.example.courses.features.mainhost.presentation.section.viewmodel.ProfileSectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainHostModule = module {

	viewModel {
		MainHostViewModel(
			mainHostRouter = get(),
		)
	}

	viewModel {
		MainSectionViewModel(
			navSectionRouter = get(named(MAIN_SECTION)),
		)
	}

	viewModel {
		FavoritesSectionViewModel(
			navSectionRouter = get(named(FAVORITES_SECTION)),
		)
	}

	viewModel {
		ProfileSectionViewModel(
			navSectionRouter = get(named(PROFILE_SECTION)),
		)
	}
}
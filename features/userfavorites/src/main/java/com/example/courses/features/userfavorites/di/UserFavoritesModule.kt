package com.example.courses.features.userfavorites.di

import com.example.courses.features.userfavorites.presentation.UserFavoritesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val UserFavoritesModule = module{
	viewModel {
		UserFavoritesViewModel(
			deleteCourseUseCase = get(),
			getAllFavoritesCoursesUseCase = get(),
		)
	}
}
package com.example.courses.navigation.di

import com.example.courses.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
	viewModel {
		MainViewModel(
			router = get(),
		)
	}
}
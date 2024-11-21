package com.example.courses.features.main.courses.di

import com.example.courses.components.presentation.mvicore.EventHandler
import com.example.courses.components.presentation.mvicore.EventHandlerImpl
import com.example.courses.core.network.createRetrofitService
import com.example.courses.core.network.getRetrofit
import com.example.courses.features.main.courses.data.api.CoursesApi
import com.example.courses.features.main.courses.data.repository.CoursesRepositoryImpl
import com.example.courses.features.main.courses.domain.repository.CoursesRepository
import com.example.courses.features.main.courses.domain.usecase.GetCoursesUseCase
import com.example.courses.features.main.courses.presentation.CoursesEvent
import com.example.courses.features.main.courses.presentation.CoursesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coursesModule = module {
	factory { createRetrofitService<CoursesApi>(getRetrofit()) }

	factory<CoursesRepository> { CoursesRepositoryImpl(get()) }

	factory { GetCoursesUseCase(get()) }

	factory<EventHandler<CoursesEvent>> { EventHandlerImpl() }

	viewModel {
		CoursesViewModel(
			getCoursesUseCase = get(),
			eventHandler = get(),
			router = get(),
			getAllFavoritesCoursesUseCase = get(),
			saveFavoritesCoursesUseCase = get(),
			deleteCourseUseCase = get(),
		)
	}
}
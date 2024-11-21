package com.example.courses.features.main.details.di

import com.example.courses.components.presentation.mvicore.EventHandler
import com.example.courses.components.presentation.mvicore.EventHandlerImpl
import com.example.courses.core.network.createRetrofitService
import com.example.courses.core.network.getRetrofit
import com.example.courses.features.main.details.data.repository.DetailsRepositoryImpl
import com.example.courses.features.main.details.domain.repository.DetailsRepository
import com.example.courses.features.main.details.domain.usecase.GetDetailsUseCase
import com.example.courses.features.main.details.presentation.DetailsEvent
import com.example.courses.features.main.details.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
	factory { createRetrofitService<com.example.courses.features.main.details.data.api.DetailsApi>(getRetrofit()) }

	factory<DetailsRepository> { DetailsRepositoryImpl(get()) }

	factory { GetDetailsUseCase(get()) }

	factory<EventHandler<DetailsEvent>> { EventHandlerImpl() }

	viewModel { (courseId: Int) ->
		DetailsViewModel(
			getDetailsUseCase = get(),
			deleteCourseUseCase = get(),
			getAllFavoritesCoursesUseCase = get(),
			eventHandler = get(),
			router = get(),
			courseId = courseId,
			saveFavoritesCoursesUseCase = get(),
		)
	}
}
package com.example.courses.shared.favorite.di

import androidx.room.Room
import com.example.courses.shared.favorite.data.config.FavoriteDatabase
import com.example.courses.shared.favorite.data.repository.FavoriteRepositoryImpl
import com.example.courses.shared.favorite.domain.repository.FavoriteRepository
import com.example.courses.shared.favorite.domain.usecase.DeleteCourseUseCase
import com.example.courses.shared.favorite.domain.usecase.GetAllFavoritesCoursesUseCase
import com.example.courses.shared.favorite.domain.usecase.GetAllIdUseCase
import com.example.courses.shared.favorite.domain.usecase.SaveCourseUseCase
import org.koin.dsl.module

val favoriteModule = module {
	single {
		Room.databaseBuilder(
			get(),
			FavoriteDatabase::class.java,
			"favorite_database"
		).build()
	}

	factory { get<FavoriteDatabase>().FavoriteDao() }

	factory<FavoriteRepository> { FavoriteRepositoryImpl(dao = get()) }

	factory { SaveCourseUseCase(repository = get()) }
	factory { GetAllIdUseCase(repository = get()) }
	factory { GetAllFavoritesCoursesUseCase(repository = get()) }
	factory { DeleteCourseUseCase(repository = get()) }

}
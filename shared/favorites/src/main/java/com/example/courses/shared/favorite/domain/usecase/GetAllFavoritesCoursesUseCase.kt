package com.example.courses.shared.favorite.domain.usecase

import com.example.courses.shared.favorite.domain.entity.Favorite
import com.example.courses.shared.favorite.domain.repository.FavoriteRepository

class GetAllFavoritesCoursesUseCase (
	private val repository: FavoriteRepository
) : suspend () -> List<Favorite> by repository::getAll
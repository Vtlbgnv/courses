package com.example.courses.shared.favorite.domain.usecase

import com.example.courses.shared.favorite.domain.entity.Favorite
import com.example.courses.shared.favorite.domain.repository.FavoriteRepository

class SaveCourseUseCase(
	private val repository: FavoriteRepository
) : suspend (Favorite) -> Unit by repository::save
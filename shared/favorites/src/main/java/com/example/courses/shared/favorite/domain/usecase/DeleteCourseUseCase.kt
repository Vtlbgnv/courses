package com.example.courses.shared.favorite.domain.usecase

import com.example.courses.shared.favorite.domain.repository.FavoriteRepository

class DeleteCourseUseCase(
	private val repository: FavoriteRepository
) : suspend (Int) -> Unit by repository::deleteById
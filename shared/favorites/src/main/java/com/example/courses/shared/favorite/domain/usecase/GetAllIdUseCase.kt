package com.example.courses.shared.favorite.domain.usecase

import com.example.courses.shared.favorite.domain.repository.FavoriteRepository

class GetAllIdUseCase(
	private val repository: FavoriteRepository
) : suspend () -> List<Int> by repository::getId
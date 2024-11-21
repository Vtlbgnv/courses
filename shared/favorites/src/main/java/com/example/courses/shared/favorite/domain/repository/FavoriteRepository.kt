package com.example.courses.shared.favorite.domain.repository

import com.example.courses.shared.favorite.domain.entity.Favorite

interface FavoriteRepository {

	suspend fun getAll(): List<Favorite>

	suspend fun getId(): List<Int>

	suspend fun save(course: Favorite)

	suspend fun deleteById(id:Int)
}
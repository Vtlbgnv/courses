package com.example.courses.shared.favorite.data.repository

import com.example.courses.shared.favorite.data.dao.FavoriteDao
import com.example.courses.shared.favorite.data.mapper.toEntity
import com.example.courses.shared.favorite.data.mapper.toModel
import com.example.courses.shared.favorite.domain.entity.Favorite
import com.example.courses.shared.favorite.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(private val dao: FavoriteDao) : FavoriteRepository {

	override suspend fun getAll(): List<Favorite> =
		dao.getAll().toEntity()

	override suspend fun getId(): List<Int> =
		dao.getAllId()

	override suspend fun save(course: Favorite) =
		dao.save(course = course.toModel())

	override suspend fun deleteById(id:Int) =
		dao.deleteById(id)
}
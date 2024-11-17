package com.example.courses.features.main.courses.data.repository

import com.example.courses.features.main.courses.data.api.CoursesApi
import com.example.courses.features.main.courses.data.mapper.toEntity
import com.example.courses.features.main.courses.domain.entity.Courses
import com.example.courses.features.main.courses.domain.repository.CoursesRepository

class CoursesRepositoryImpl(private val api: CoursesApi) : CoursesRepository {

	override suspend fun getCourses(page: Int): Courses {
		return api.getCourses(page = page).toEntity()
	}
}
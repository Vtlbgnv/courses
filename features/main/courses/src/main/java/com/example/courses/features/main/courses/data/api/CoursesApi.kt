package com.example.courses.features.main.courses.data.api

import com.example.courses.features.main.courses.data.model.CoursesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CoursesApi {

	private companion object {

		const val LANGUAGE = "ru"
		const val PAGE = 1
		const val PAGE_SIZE = 1
		const val IS_PUBLIC = true
	}

	@GET("/api/courses/")
	suspend fun getCourses(
		@Query("page") page: Int = PAGE,
		@Query("page_size") pageSize: Int = PAGE_SIZE,
		@Query("page_size") language: String = LANGUAGE,
		@Query("is_public") isPublic: Boolean = IS_PUBLIC,
	): CoursesModel
}
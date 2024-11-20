package com.example.courses.features.main.details.data.api

import com.example.courses.features.main.details.data.model.CoursesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsApi {

	@GET("/api/courses/{pk}")
	suspend fun getCourseInfo(
		@Path("pk") id: String,
	): CoursesResponse
}
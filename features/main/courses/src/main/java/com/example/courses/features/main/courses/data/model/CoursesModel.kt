package com.example.courses.features.main.courses.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoursesModel(
	val meta: MetaModel,
	val courses: List<CourseModel>
)

data class MetaModel(
	val page: Int,
	@Json(name = "has_next")
	val hasNext: Boolean,
	@Json(name = "has_previous")
	val hasPrevious: Boolean
)

data class CourseModel(
	val id: Int,
	val cover: String,
	val title: String,
	val summary: String,
	@Json(name = "is_paid")
	val isPaid: Boolean,
	@Json(name = "display_price")
	val displayPrice: String,
	@Json(name = "became_published_at")
	val publishedDate: String
)


package com.example.courses.features.main.details.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoursesResponse(
	val meta: Meta,
	val courses: List<CourseInfoModel>
)

@JsonClass(generateAdapter = true)
data class Meta(
	val page: Int,
	@Json(name = "has_next")
	val hasNext: Boolean,
	@Json(name = "has_previous")
	val hasPrevious: Boolean
)

@JsonClass(generateAdapter = true)
data class CourseInfoModel(
	val id: Int,
	val cover: String,
	val title: String,
	val summary: String,
	val description: String,
	@Json(name = "canonical_url")
	val canonicalUrl: String,
	@Json(name = "is_paid")
	val isPaid: Boolean,
	@Json(name = "display_price")
	val displayPrice: String,
	@Json(name = "became_published_at")
	val publishedDate: String
)

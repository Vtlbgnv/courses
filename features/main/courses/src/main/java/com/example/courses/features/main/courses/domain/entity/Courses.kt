package com.example.courses.features.main.courses.domain.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Courses(
	val meta: Meta,
	val courses: List<Course>
)

data class Meta(
	val page: Int,
	val hasNext: Boolean,
	val hasPrevious: Boolean
)

data class Course(
	val id: Int,
	val cover: String,
	val rank: String,
	val isFavorite: Boolean,
	val title: String,
	val summary: String,
	val isPaid: Boolean,
	val displayPrice: String,
	val publishedDate: String
)
package com.example.courses.features.main.details.domain.entity

data class CourseInfo(
	val id: Int,
	val cover: String,
	val title: String,
	val hasFavorites: Boolean,
	val description: String,
	val rank: String,
	val canonicalUrl: String,
	val isPaid: Boolean,
	val displayPrice: String,
	val publishedDate: String,
)
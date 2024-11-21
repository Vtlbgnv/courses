package com.example.courses.features.userfavorites.presentation.entity

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
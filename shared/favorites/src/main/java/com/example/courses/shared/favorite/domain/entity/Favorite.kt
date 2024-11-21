package com.example.courses.shared.favorite.domain.entity

data class Favorite(
	val id: Int,
	val cover: String,
	val rank: String,
	val title: String,
	val summary: String,
	val isPaid: Boolean,
	val displayPrice: String,
	val publishedDate: String
)
package com.example.courses.shared.favorite.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteModel(
	@PrimaryKey
	val id: Int,
	val cover: String,
	val rank: String,
	val title: String,
	val summary: String,
	val isPaid: Boolean,
	val displayPrice: String,
	val publishedDate: String
)
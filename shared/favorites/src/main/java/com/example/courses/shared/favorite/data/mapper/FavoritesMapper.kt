package com.example.courses.shared.favorite.data.mapper

import com.example.courses.shared.favorite.data.model.FavoriteModel
import com.example.courses.shared.favorite.domain.entity.Favorite

fun Favorite.toModel(): FavoriteModel =
	FavoriteModel(
		id = id,
		cover = cover,
		rank = rank,
		title = title,
		summary = summary,
		isPaid = isPaid,
		displayPrice = displayPrice,
		publishedDate = publishedDate,
	)

fun List<FavoriteModel>.toEntity(): List<Favorite> =
	map { it.toEntity() }

private fun FavoriteModel.toEntity(): Favorite =
	Favorite(
		id = id,
		cover = cover,
		rank = rank,
		title = title,
		summary = summary,
		isPaid = isPaid,
		displayPrice = displayPrice,
		publishedDate = publishedDate,
	)
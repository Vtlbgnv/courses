package com.example.courses.features.userfavorites.presentation.converter

import com.example.courses.features.userfavorites.presentation.entity.Course
import com.example.courses.shared.favorite.domain.entity.Favorite

fun List<Favorite>.toEntity(): List<Course> =
	map { it.toEntity() }

fun Favorite.toEntity(): Course =
	Course(
		id = id,
		cover = cover,
		rank = rank,
		title = title,
		summary = summary,
		isPaid = isPaid,
		displayPrice = displayPrice,
		publishedDate = publishedDate,
		isFavorite = true,
	)


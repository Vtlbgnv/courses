package com.example.courses.features.main.details.data.mapper

import com.example.courses.components.presentation.converter.formatDate
import com.example.courses.components.presentation.converter.textFormat
import com.example.courses.components.presentation.utils.randomValue
import com.example.courses.features.main.details.data.model.CoursesResponse
import com.example.courses.features.main.details.domain.entity.CourseInfo

fun CoursesResponse.toEntity(): CourseInfo =
	CourseInfo(
		id = courses[0].id,
		cover = courses[0].cover,
		title = courses[0].title,
		hasFavorites = true,
		description = textFormat(courses[0].description),
		canonicalUrl = courses[0].canonicalUrl,
		isPaid = courses[0].isPaid,
		displayPrice = courses[0].displayPrice,
		publishedDate = formatDate(courses[0].publishedDate),
		rank = randomValue()
	)
package com.example.courses.features.main.courses.data.mapper

import com.example.courses.components.presentation.converter.formatDate
import com.example.courses.components.presentation.utils.randomValue
import com.example.courses.features.main.courses.data.model.CourseModel
import com.example.courses.features.main.courses.data.model.CoursesModel
import com.example.courses.features.main.courses.data.model.MetaModel
import com.example.courses.features.main.courses.domain.entity.Course
import com.example.courses.features.main.courses.domain.entity.Courses
import com.example.courses.features.main.courses.domain.entity.Meta

internal fun CoursesModel.toEntity(): Courses =
	Courses(
		meta = meta.toEntity(),
		courses = courses.map { it.toEntity() }
	)

private fun CourseModel.toEntity(): Course =
	Course(
		id = id,
		title = title,
		summary = summary,
		rank = randomValue(),
		cover = cover,
		isPaid = isPaid,
		displayPrice = displayPrice,
		publishedDate = formatDate(publishedDate),
		isFavorite = false,
	)

private fun MetaModel.toEntity(): Meta =
	Meta(
		page = page,
		hasNext = hasNext,
		hasPrevious = hasPrevious,
	)
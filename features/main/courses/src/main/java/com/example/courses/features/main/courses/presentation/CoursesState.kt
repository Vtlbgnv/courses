package com.example.courses.features.main.courses.presentation

import com.example.courses.components.presentation.mvicore.State
import com.example.courses.features.main.courses.domain.entity.Course
import com.example.courses.features.main.courses.domain.entity.Meta

data class CoursesState(
	val courses: List<Course>,
	val meta: Meta,
	val loadingPrevious:Boolean,
	val loadingNext:Boolean,
	val status: Status
) : State

enum class Status {
	INITIAL,
	CONTENT,
	ERROR,
}

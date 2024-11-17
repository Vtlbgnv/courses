package com.example.courses.features.main.courses.domain.usecase

import com.example.courses.features.main.courses.domain.entity.Courses
import com.example.courses.features.main.courses.domain.repository.CoursesRepository

class GetCoursesUseCase(
	private val repository: CoursesRepository
) : suspend (Int) -> Courses by repository::getCourses
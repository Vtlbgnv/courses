package com.example.courses.features.main.courses.domain.repository

import com.example.courses.features.main.courses.domain.entity.Courses

interface CoursesRepository {

	suspend fun getCourses(page:Int): Courses
}
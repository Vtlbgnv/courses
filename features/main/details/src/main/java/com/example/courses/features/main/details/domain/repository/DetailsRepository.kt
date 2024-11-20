package com.example.courses.features.main.details.domain.repository

import com.example.courses.features.main.details.domain.entity.CourseInfo

interface DetailsRepository {

	suspend fun getDetails(id: String): CourseInfo
}


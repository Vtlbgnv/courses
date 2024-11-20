package com.example.courses.features.main.details.data.repository

import com.example.courses.features.main.details.data.api.DetailsApi
import com.example.courses.features.main.details.data.mapper.toEntity
import com.example.courses.features.main.details.domain.entity.CourseInfo
import com.example.courses.features.main.details.domain.repository.DetailsRepository

class DetailsRepositoryImpl(private val api: DetailsApi) : DetailsRepository {

	override suspend fun getDetails(id: String): CourseInfo {
		return api.getCourseInfo(id).toEntity()
	}
}
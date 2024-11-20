package com.example.courses.features.main.details.domain.usecase

import com.example.courses.features.main.details.domain.entity.CourseInfo

class GetDetailsUseCase(
	private val repository: com.example.courses.features.main.details.domain.repository.DetailsRepository
) : suspend (String) -> CourseInfo by repository::getDetails
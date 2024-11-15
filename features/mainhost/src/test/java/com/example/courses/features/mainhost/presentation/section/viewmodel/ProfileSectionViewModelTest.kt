package com.example.courses.features.mainhost.presentation.section.viewmodel

import com.example.courses.features.mainhost.presentation.section.NavSectionRouter
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class ProfileSectionViewModelTest {

	private val navSectionRouter: NavSectionRouter = mock()
	private val viewModel: ProfileSectionViewModel = ProfileSectionViewModel(navSectionRouter)

	@Test
	fun `when try to init router EXPECT router init() method invocation`() {
		viewModel.initRouter()

		verify(navSectionRouter).init()
	}
}
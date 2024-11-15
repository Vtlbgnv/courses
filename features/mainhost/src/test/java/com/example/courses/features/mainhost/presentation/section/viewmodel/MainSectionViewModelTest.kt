package com.example.courses.features.mainhost.presentation.section.viewmodel

import com.example.courses.features.mainhost.presentation.section.NavSectionRouter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MainSectionViewModelTest {

	private val navSectionRouter: NavSectionRouter = mock()
	private val viewModel: MainSectionViewModel = MainSectionViewModel(navSectionRouter)

	@Test
	fun `when try to init router EXPECT router init() method invocation`() {
		viewModel.initRouter()

		verify(navSectionRouter).init()
	}
}
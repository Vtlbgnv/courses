package com.example.courses.features.mainhost.presentation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class MainHostViewModelTest {

	private val mainHostRouter: MainHostRouter = mock()
	private val viewModel: MainHostViewModel = MainHostViewModel(
		mainHostRouter = mainHostRouter,
	)

	@Test
	fun `viewModel init EXPECT navigate to MainScreen`() {

		verify(mainHostRouter).navigateToMainSection()
	}

	@Test
	fun `try to navigate to favorites section EXPECT navigateToFavoriteSection() router method invocation`() {
		viewModel.navigateToFavoriteSection()

		verify(mainHostRouter).navigateToFavoriteSection()
	}

	@Test
	fun `try to navigate to profile section EXPECT navigateToProfileSection() router method invocation`() {
		viewModel.navigateToProfileSection()

		verify(mainHostRouter).navigateToProfileSection()
	}

	@Test
	fun `try to navigate back EXPECT navigateBack() router method invocation`() {
		viewModel.navigateBack()

		verify(mainHostRouter).navigateBack()
	}
}
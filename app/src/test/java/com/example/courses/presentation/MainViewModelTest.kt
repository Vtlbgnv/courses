package com.example.courses.presentation

import com.example.courses.core.navigation.router.GlobalRouter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any

@ExtendWith(MockitoExtension::class)
class MainViewModelTest {

	private val router: GlobalRouter = mock()
	private val viewModel = MainViewModel(
		router = router,
	)

	@Test
	fun `set start screen invoke EXPECT new root screen method invocation`() {
		viewModel.setStartScreen()

		verify(router).newRootScreen(any())
	}
}
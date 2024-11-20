package com.example.courses.features.main.details.presentation

import androidx.lifecycle.viewModelScope
import com.example.courses.components.presentation.mvicore.BaseViewModel
import com.example.courses.components.presentation.mvicore.EventHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class DetailsViewModel(
	private val getDetailsUseCase: com.example.courses.features.main.details.domain.usecase.GetDetailsUseCase,
	eventHandler: EventHandler<DetailsEvent>,
	private val router: DetailsRouter,
	private val courseId: Int,
) : BaseViewModel<DetailsState, DetailsIntent>(),
	EventHandler<DetailsEvent> by eventHandler {

	private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
		setState(DetailsState.Error)
	}

	override fun initState(): DetailsState = DetailsState.Initial

	override fun applyIntent(intent: DetailsIntent) {
		when (intent) {
			is DetailsIntent.LoadCourse   -> handleLoadCourse()
			is DetailsIntent.AddFavorites -> handleAddFavorites(intent.hasFavorites, intent.id)
			is DetailsIntent.NavigateBack -> handleNavigateBack()
			is DetailsIntent.OpenLink     -> handleOpenLink(intent.url)
		}
	}

	private fun handleLoadCourse() {
		setState(DetailsState.Loading)

		viewModelScope.launch(exceptionHandler) {
			setState(
				DetailsState.Content(
					courseInfo = getDetailsUseCase(courseId.toString())
				)
			)
		}
	}

	private fun handleAddFavorites(
		hasFavorites: Boolean,
		id: Int
	) {
		val currentState = uiState.value as? DetailsState.Content ?: return

		setState(
			DetailsState.Content(
				courseInfo = currentState.courseInfo.copy(
					hasFavorites = hasFavorites
				)
			)
		)
	}

	private fun handleNavigateBack() {
		// TODO fix navigation
		router.navigateBack()
	}

	private fun handleOpenLink(url: String) {
		router.openUrl(url)
	}
}
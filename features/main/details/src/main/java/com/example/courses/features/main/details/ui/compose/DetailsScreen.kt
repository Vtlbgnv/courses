package com.example.courses.features.main.details.ui.compose

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.courses.components.ui.compose.EmptyContent
import com.example.courses.features.main.details.ui.compose.content.DetailsContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun DetailsScreen(
	uiState: StateFlow<com.example.courses.features.main.details.presentation.DetailsState>,
	applyIntent: (com.example.courses.features.main.details.presentation.DetailsIntent) -> Unit,
	uiEventFlow: Flow<com.example.courses.features.main.details.presentation.DetailsEvent>,
) {
	val state by uiState.collectAsState()

	Scaffold {
		when (state) {
			is com.example.courses.features.main.details.presentation.DetailsState.Initial -> {
				applyIntent(com.example.courses.features.main.details.presentation.DetailsIntent.LoadCourse)
			}

			is com.example.courses.features.main.details.presentation.DetailsState.Loading -> {
				EmptyContent(message = "Загрузка")
			}

			is com.example.courses.features.main.details.presentation.DetailsState.Content -> {
				val contentState = (state as com.example.courses.features.main.details.presentation.DetailsState.Content).courseInfo

				DetailsContent(
					id = contentState.id,
					cover = contentState.cover,
					title = contentState.title,
					rank = contentState.rank,
					canonicalUrl = contentState.canonicalUrl,
					hasFavorites = contentState.hasFavorites,
					description = contentState.description,
					isPaid = contentState.isPaid,
					displayPrice = contentState.displayPrice,
					publishedDate = contentState.publishedDate,
					onFavoritesClick = { isFavorite, courseId ->
						applyIntent(com.example.courses.features.main.details.presentation.DetailsIntent.AddFavorites(id = courseId, hasFavorites = isFavorite))
					},
					onOpenUrlClick = { applyIntent(com.example.courses.features.main.details.presentation.DetailsIntent.OpenLink(it)) }
				)
			}

			is com.example.courses.features.main.details.presentation.DetailsState.Error   -> {
				EmptyContent(message = "Ошибка")
			}
		}
	}
}

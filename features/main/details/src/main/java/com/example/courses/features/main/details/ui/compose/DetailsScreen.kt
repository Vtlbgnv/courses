package com.example.courses.features.main.details.ui.compose

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.courses.components.ui.compose.EmptyContent
import com.example.courses.features.main.details.presentation.DetailsEvent
import com.example.courses.features.main.details.presentation.DetailsIntent
import com.example.courses.features.main.details.presentation.DetailsState
import com.example.courses.features.main.details.ui.compose.content.DetailsContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun DetailsScreen(
	uiState: StateFlow<DetailsState>,
	applyIntent: (DetailsIntent) -> Unit,
	uiEventFlow: Flow<DetailsEvent>,
) {
	val state by uiState.collectAsState()

	Scaffold {
		when (state) {
			is DetailsState.Initial -> {
				applyIntent(DetailsIntent.LoadCourse)
			}

			is DetailsState.Loading -> {
				EmptyContent(message = "Загрузка")
			}

			is DetailsState.Content -> {
				val contentState = (state as DetailsState.Content).courseInfo

				DetailsContent(
					cover = contentState.cover,
					title = contentState.title,
					rank = contentState.rank,
					canonicalUrl = contentState.canonicalUrl,
					hasFavorites = contentState.hasFavorites,
					description = contentState.description,
					isPaid = contentState.isPaid,
					displayPrice = contentState.displayPrice,
					publishedDate = contentState.publishedDate,
					onFavoritesClick = { applyIntent(DetailsIntent.AddFavorites(hasFavorites = it)) },
					onOpenUrlClick = { applyIntent(DetailsIntent.OpenLink(it)) }
				)
			}

			is DetailsState.Error   -> {
				EmptyContent(message = "Ошибка")
			}
		}
	}
}

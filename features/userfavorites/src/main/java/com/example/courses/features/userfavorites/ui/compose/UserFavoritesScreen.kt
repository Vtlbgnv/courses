package com.example.courses.features.userfavorites.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.EmptyContent
import com.example.courses.features.userfavorites.presentation.UserFavoritesIntent
import com.example.courses.features.userfavorites.presentation.UserFavoritesState
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserFavoritesScreen(
	uiState: StateFlow<UserFavoritesState>,
	applyIntent: (UserFavoritesIntent) -> Unit,
) {
	val state by uiState.collectAsState()

	Scaffold {
		Box(
			modifier = Modifier
				.fillMaxSize()
		) {
			when (state) {
				is UserFavoritesState.Initial -> {
					applyIntent(UserFavoritesIntent.LoadCourses)
				}

				is UserFavoritesState.Loading -> {
					EmptyContent(message = "Загрузка")
				}

				is UserFavoritesState.Content -> {
					val contentState = (state as UserFavoritesState.Content)
					if (contentState.courses.isEmpty()) {
						EmptyContent(onRetryClick = { applyIntent(UserFavoritesIntent.LoadCourses) })
					} else {
						LazyColumn(
							modifier = Modifier.padding(horizontal = 16.dp)
						) {
							UserFavoritesContent(
								state = contentState,
								onFavoriteClick = {
									applyIntent(UserFavoritesIntent.RemoveFavorites(it))
								}
							)
						}
					}
				}

				is UserFavoritesState.Error   -> {
					EmptyContent(message = "Ошибка")
				}
			}
		}
	}
}
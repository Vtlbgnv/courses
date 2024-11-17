package com.example.courses.features.main.courses.ui.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.Pagination
import com.example.courses.features.main.courses.presentation.CoursesEvent
import com.example.courses.features.main.courses.presentation.CoursesIntent
import com.example.courses.features.main.courses.presentation.CoursesState
import com.example.courses.features.main.courses.ui.compose.content.CoursesContent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun CoursesScreen(
	uiState: StateFlow<CoursesState>,
	applyIntent: (CoursesIntent) -> Unit,
	uiEventFlow: Flow<CoursesEvent>,
) {
	val state by uiState.collectAsState()
	val lazyListState = rememberLazyListState()

	Scaffold {
		Box(
			modifier = Modifier
				.fillMaxSize()
		) {
			LazyColumn(
				state = lazyListState,
				modifier = Modifier.padding(horizontal = 16.dp)
			) {
				CoursesContent(
					state = state,
					onLoad = { applyIntent(CoursesIntent.LoadCourses) },
					onMoreDetailsClick = { applyIntent(CoursesIntent.NavigateToDetailsScreen(it)) }
				)
			}

			Pagination(
				lazyListState = lazyListState,
				itemsCount = state.courses.size,
				priorItemsCount = 3,
				loadThreshold = 4,
				onLoadMore = { applyIntent(CoursesIntent.LoadCourses) },
				onLoadPrevious = { applyIntent(CoursesIntent.LoadPreviousPage) },
				hasNext = state.meta.hasNext,
				hasPrevious = state.meta.hasPrevious,
			)

			LaunchedEffect(key1 = true) {
				uiEventFlow.collect {
					// TODO Add events handling. For example show snackBar
				}
			}
		}
	}
}

package com.example.courses.features.main.courses.ui.compose.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.CourseCard
import com.example.courses.components.ui.compose.EmptyContent
import com.example.courses.components.ui.compose.TextInputField
import com.example.courses.features.main.courses.R
import com.example.courses.features.main.courses.presentation.CoursesState
import com.example.courses.features.main.courses.presentation.Status

private const val NUMBER_ITEMS_LOADING = 5

internal fun LazyListScope.CoursesContent(
	state: CoursesState,
	onMoreDetailsClick: (Int) -> Unit,
	onFavoriteClick: (Int, Boolean) -> Unit,
	onLoad: () -> Unit,
) {
	item {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 32.dp, bottom = 24.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			TextInputField(
				text = "",
				label = stringResource(id = R.string.search),
				icon = Icons.Default.Search,
				onTextChange = {},
				enabled = false,
				modifier = Modifier.weight(1f)
			)

			IconButton(
				onClick = { /*TODO*/ },
				modifier = Modifier
					.padding(horizontal = 8.dp)
					.background(
						color = MaterialTheme.colorScheme.surface,
						shape = RoundedCornerShape(50)
					)
					.align(Alignment.CenterVertically)
					.padding(4.dp)
			) {
				Icon(
					painter = painterResource(id = R.drawable.ic_filter),
					contentDescription = null
				)
			}
		}
	}

	if (state.loadingNext) {
		items(NUMBER_ITEMS_LOADING) {
			Text(text = "Loading previous")

			Spacer(modifier = Modifier.height(16.dp))
		}
	}

	if (state.status == Status.CONTENT && state.courses.isNotEmpty()) {

		if (state.loadingPrevious) {
			items(NUMBER_ITEMS_LOADING) {
				Text(text = "Loading previous")

				Spacer(modifier = Modifier.height(16.dp))
			}
		}

		items(
			count = state.courses.count(),
			key = { index -> state.courses[index].id }
		) { index ->
			val course = state.courses[index]
			CourseCard(
				id = course.id,
				imageUrl = course.cover,
				rating = course.rank,
				isFavorite  = course.isFavorite,
				publishedDate = course.publishedDate,
				title = course.title,
				description = course.summary,
				price = course.displayPrice,
				isPaid = course.isPaid,
				onMoreDetailsClick = {
					onMoreDetailsClick(it)
				},
				onFavoritesClick = { id, isFavorite ->
					onFavoriteClick(id, isFavorite)
				},
			)

			Spacer(modifier = Modifier.height(16.dp))
		}

		if (state.loadingNext) {
			items(NUMBER_ITEMS_LOADING) {
				Text(text = "Loading next")

				Spacer(modifier = Modifier.height(16.dp))
			}
		}
	}

	if (state.courses.isEmpty() && !state.loadingNext && !state.loadingPrevious) {
		item {
			EmptyContent(onRetryClick = onLoad)
		}
	}

	if (state.status == Status.ERROR) {
		item { Text(text = "Ошибка") }
	}
}


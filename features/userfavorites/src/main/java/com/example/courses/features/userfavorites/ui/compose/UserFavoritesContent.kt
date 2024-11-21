package com.example.courses.features.userfavorites.ui.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.BaseText
import com.example.courses.components.ui.compose.CourseCard
import com.example.courses.features.userfavorites.R
import com.example.courses.features.userfavorites.presentation.UserFavoritesState

fun LazyListScope.UserFavoritesContent(
	state: UserFavoritesState.Content,
	onFavoriteClick: (Int) -> Unit,
) {
	item {
		BaseText(
			text = stringResource(R.string.favorits_title),
			style = MaterialTheme.typography.titleMedium,
			modifier = Modifier.padding(
				top = 56.dp,
				bottom = 16.dp
			)
		)
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
			isFavorite = course.isFavorite,
			publishedDate = course.publishedDate,
			title = course.title,
			description = course.summary,
			price = course.displayPrice,
			isPaid = course.isPaid,
			onMoreDetailsClick = {
				//TODO
			},
			onFavoritesClick = { id, _ ->
				onFavoriteClick(id)
			},
		)

		Spacer(modifier = Modifier.height(16.dp))
	}
}

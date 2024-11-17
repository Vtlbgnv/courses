package com.example.courses.components.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.courses.components.ui.R

@Composable
fun CourseCard(
	id: Int,
	imageUrl: String,
	rating: String,
	publishedDate: String,
	title: String,
	description: String,
	price: String,
	isPaid: Boolean,
	onMoreDetailsClick: (Int) -> Unit,
	onFavoritesClick: (Int) -> Unit,
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
			.clip(RoundedCornerShape(12.dp))
			.background(color = MaterialTheme.colorScheme.surface)
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.height(114.dp)
				.clip(RoundedCornerShape(12.dp))
		) {
			Image(
				painter = rememberAsyncImagePainter(model = imageUrl),
				contentDescription = null,
				contentScale = ContentScale.FillBounds,
				modifier = Modifier
					.fillMaxWidth()
					.height(114.dp)
			)

			Row(
				modifier = Modifier
					.align(Alignment.BottomStart)
					.padding(start = 8.dp)
					.padding(vertical = 4.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier
						.background(
							color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f),
							shape = RoundedCornerShape(50)
						)
						.padding(
							horizontal = 8.dp,
							vertical = 2.dp
						)
				) {
					Icon(
						imageVector = Icons.Default.Star,
						contentDescription = null,
						tint = MaterialTheme.colorScheme.primary,
						modifier = Modifier
							.size(16.dp)
							.padding(vertical = 3.dp),
					)

					BaseText(
						text = rating,
						style = MaterialTheme.typography.bodyMedium,
					)
				}

				Spacer(modifier = Modifier.width(8.dp))

				BaseText(
					text = publishedDate,
					modifier = Modifier
						.background(
							color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f),
							shape = RoundedCornerShape(50)
						)
						.padding(
							horizontal = 8.dp,
							vertical = 2.dp
						),
					style = MaterialTheme.typography.bodyMedium
				)
			}

			IconButton(
				onClick = { onFavoritesClick(id) },
				modifier = Modifier
					.padding(8.dp)
					.background(
						color = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f),
						shape = RoundedCornerShape(50)
					)
					.padding(6.dp)
					.align(Alignment.TopEnd)
					.size(20.dp),
			) {
				Icon(
					painter = painterResource(id = R.drawable.ic_bookmark),
					contentDescription = null,
					tint = MaterialTheme.colorScheme.onSurface,
				)
			}

		}

		BaseText(
			text = title,
			style = MaterialTheme.typography.bodyLarge,
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.padding(vertical = 12.dp),
		)

		BaseText(
			text = description,
			color = MaterialTheme.colorScheme.onSecondary,
			maxLines = 2,
			overflow = TextOverflow.Ellipsis,
			style = MaterialTheme.typography.bodySmall,
			modifier = Modifier
				.padding(horizontal = 16.dp)
		)

		Row(
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					horizontal = 16.dp,
				),
			verticalAlignment = Alignment.CenterVertically
		) {

			BaseText(
				text = if (isPaid) {
					price
				} else {
					stringResource(id = R.string.free_course)
				},
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.bodyLarge,
			)


			TextButton(
				onClick = { onMoreDetailsClick(id) },
			) {
				Row(
					verticalAlignment = Alignment.CenterVertically
				) {
					BaseText(
						text = stringResource(id = R.string.more_info),
						color = MaterialTheme.colorScheme.primary,
						style = MaterialTheme.typography.labelSmall
					)

					Icon(
						painter = painterResource(id = R.drawable.ic_next),
						contentDescription = null,
						modifier = Modifier.padding(start = 4.dp)
					)
				}
			}
		}
	}
}

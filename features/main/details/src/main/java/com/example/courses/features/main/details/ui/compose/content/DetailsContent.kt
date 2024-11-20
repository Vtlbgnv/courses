package com.example.courses.features.main.details.ui.compose.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.courses.components.ui.compose.BaseText
import com.example.courses.features.main.details.R
import com.example.courses.components.ui.R as componentR

@Composable
fun DetailsContent(
	id: Int,
	cover: String,
	title: String,
	canonicalUrl: String,
	rank: String,
	hasFavorites: Boolean,
	description: String,
	isPaid: Boolean,
	displayPrice: String,
	publishedDate: String,
	onFavoritesClick: (Boolean, Int) -> Unit,
	onOpenUrlClick: (String) -> Unit,
	modifier: Modifier = Modifier,
	authorName: String = stringResource(id = R.string.academy),
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState())
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.height(240.dp)
		) {
			Image(
				painter = rememberAsyncImagePainter(model = cover),
				contentDescription = null,
				contentScale = ContentScale.FillBounds,
				modifier = Modifier
					.fillMaxSize()
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
						text = rank,
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


			Row(
				modifier = Modifier
					.align(Alignment.TopEnd)
					.padding(top = 56.dp)
					.padding(horizontal = 16.dp)
			) {
				IconButton(
					onClick = {
						// TODO fix navigation
					},
					modifier = Modifier
						.background(
							color = MaterialTheme.colorScheme.onSurface,
							shape = RoundedCornerShape(50),
						),
				) {
					Icon(
						painter = painterResource(id = R.drawable.ic_back),
						contentDescription = null,
						tint = MaterialTheme.colorScheme.background,
					)
				}

				Spacer(modifier = Modifier.weight(1f))

				IconButton(
					onClick = {
						onFavoritesClick(!hasFavorites, id)
					},
					modifier = Modifier
						.background(
							color = MaterialTheme.colorScheme.onSurface,
							shape = RoundedCornerShape(50)
						),
				) {
					Icon(
						painter = if (hasFavorites) {
							painterResource(id = R.drawable.ic_filled_favorites)
						} else {
							painterResource(id = R.drawable.ic_favorites)
						},
						contentDescription = null,
						tint = if (hasFavorites) {
							MaterialTheme.colorScheme.primary
						} else {
							MaterialTheme.colorScheme.background
						},
					)
				}
			}
		}

		BaseText(
			text = title,
			style = MaterialTheme.typography.titleMedium,
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.padding(vertical = 16.dp)
		)

		AuthorBlock(
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.padding(bottom = 32.dp),
			authorName = authorName
		)

		Button(
			onClick = { onOpenUrlClick(canonicalUrl) },
			colors = ButtonColors(
				contentColor = MaterialTheme.colorScheme.onSurface,
				containerColor = MaterialTheme.colorScheme.primary,
				disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
				disabledContentColor = MaterialTheme.colorScheme.outline,
			),
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp)
		) {
			BaseText(
				text = stringResource(id = R.string.start_cours),
				style = MaterialTheme.typography.labelMedium,
			)
		}

		Button(
			onClick = { onOpenUrlClick(canonicalUrl) },
			colors = ButtonColors(
				contentColor = MaterialTheme.colorScheme.onSurface,
				containerColor = MaterialTheme.colorScheme.surface,
				disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
				disabledContentColor = MaterialTheme.colorScheme.outline,
			),
			modifier = Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp)
		) {
			BaseText(
				text = stringResource(id = R.string.go_to_platform),
				style = MaterialTheme.typography.labelMedium,
			)
		}

		BaseText(
			text = stringResource(id = R.string.about_course),
			style = MaterialTheme.typography.titleMedium,
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.padding(
					top = 28.dp,
					bottom = 16.dp
				)
		)

		BaseText(
			text = description,
			style = MaterialTheme.typography.labelMedium.copy(
				lineHeight = 20.sp,
				letterSpacing = 0.25.sp
			),
			modifier = Modifier.padding(horizontal = 16.dp),
			color = MaterialTheme.colorScheme.onSecondary,
		)

		Row(
			Modifier
				.fillMaxWidth()
				.padding(horizontal = 16.dp)
				.padding(
					top = 28.dp,
					bottom = 16.dp
				)
		) {
			BaseText(
				text = stringResource(id = R.string.price),
				style = MaterialTheme.typography.titleMedium,
				modifier = Modifier.padding(end = 8.dp)
			)

			BaseText(
				text = if (isPaid) {
					displayPrice
				} else {
					stringResource(id = componentR.string.free_course)
				},
				style = MaterialTheme.typography.titleMedium,
			)
		}

	}
}

@Composable
private fun AuthorBlock(
	modifier: Modifier = Modifier,
	authorName: String,
	avatar: Painter = painterResource(R.drawable.avatar),
) {
	Row(modifier = modifier.fillMaxWidth()) {
		Image(
			painter = avatar,
			contentDescription = null,
			modifier = Modifier
				.clip(RoundedCornerShape(50))
				.size(40.dp)
				.align(Alignment.CenterVertically)
				.padding(end = 12.dp)
		)

		Column(
			modifier = Modifier.align(Alignment.CenterVertically)
		) {
			BaseText(
				text = stringResource(id = R.string.author),
				style = MaterialTheme.typography.labelSmall,
				color = MaterialTheme.colorScheme.onSecondary,
			)

			BaseText(
				text = authorName,
				style = MaterialTheme.typography.bodyLarge
			)
		}
	}
}

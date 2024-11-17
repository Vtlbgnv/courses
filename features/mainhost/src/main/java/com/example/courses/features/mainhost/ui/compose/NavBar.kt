package com.example.courses.features.mainhost.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.BaseText
import com.example.courses.core.navigation.utils.SectionNames
import com.example.courses.features.mainhost.R
import com.example.courses.features.mainhost.presentation.MainHostViewModel

@Composable
fun NavBar(
	viewModel: MainHostViewModel,
	modifier: Modifier = Modifier,
) {
	val navigationItemsList = listOf(
		NavigationItem(
			title = stringResource(id = R.string.main_title),
			sectionName = SectionNames.MAIN_SECTION,
			icon = {
				Icon(
					painter = painterResource(id = R.drawable.ic_main),
					contentDescription = null,
				)
			},
			navigateToSection = { viewModel.navigateToMainSection() },
		),
		NavigationItem(
			title = stringResource(id = R.string.favorites_title),
			sectionName = SectionNames.FAVORITES_SECTION,
			icon = {
				Icon(
					painter = painterResource(id = R.drawable.ic_favorites),
					contentDescription = null,
				)
			},
			navigateToSection = { viewModel.navigateToFavoriteSection() },
		),
		NavigationItem(
			title = stringResource(id = R.string.profile_section),
			sectionName = SectionNames.PROFILE_SECTION,
			icon = {
				Icon(
					painter = painterResource(id = R.drawable.ic_account),
					contentDescription = null,
				)
			},
			navigateToSection = { viewModel.navigateToProfileSection() },
		),
	)

	val selectedItem by viewModel.currentSection.collectAsState()
	val borderColor = MaterialTheme.colorScheme.outline
	var textScale: Double by remember { mutableDoubleStateOf(1.0) }
	val readyToDrawList = remember { mutableStateListOf(false, false, false) }

	NavigationBar(
		containerColor = MaterialTheme.colorScheme.surface,
		tonalElevation = 0.dp,
		modifier = modifier
			.fillMaxWidth()
			.padding(top = 4.dp)
			.drawBehind {
				val strokeWidth = 3.dp.toPx()
				val y = 0f
				drawLine(
					color = borderColor,
					start = Offset(0f, y),
					end = Offset(size.width, y),
					strokeWidth = strokeWidth
				)
			},
	) {
		navigationItemsList.forEachIndexed { index, item ->
			NavigationBarItem(
				selected = selectedItem == item.sectionName,
				label = {
					BaseText(
						text = item.title,
						style = MaterialTheme.typography.labelSmall,
						modifier = Modifier.drawWithContent {
							if (!readyToDrawList.contains(false)) {
								drawContent()
							}
						},
						textScale = textScale,
						softWrap = false,
						onTextLayout = { textLayoutResult ->
							if (textLayoutResult.didOverflowWidth) {
								textScale *= 0.9
							} else {
								readyToDrawList[index] = true
							}
						}
					)
				},
				onClick = item.navigateToSection,
				colors = NavigationBarItemDefaults.colors(
					selectedIconColor = MaterialTheme.colorScheme.primary,
					selectedTextColor = MaterialTheme.colorScheme.primary,
					unselectedIconColor = MaterialTheme.colorScheme.onSurface,
					unselectedTextColor = MaterialTheme.colorScheme.onSurface,
					indicatorColor = MaterialTheme.colorScheme.surfaceContainer,
				),
				alwaysShowLabel = true,
				icon = item.icon,
				modifier = Modifier.padding(top = 8.dp)
			)
		}
	}
}
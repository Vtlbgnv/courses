package com.example.courses.features.profile.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.compose.BaseText
import com.example.courses.features.profile.R

@Composable
internal fun ProfileScreen() {

	Box(
		modifier = Modifier.fillMaxSize(),
		contentAlignment = Alignment.Center
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.padding(horizontal = 16.dp)
		) {
			BaseText(
				text = stringResource(id = R.string.empty),
				style = MaterialTheme.typography.titleMedium,
				color = MaterialTheme.colorScheme.primary
			)

			Spacer(modifier = Modifier.height(8.dp))

			BaseText(
				text = stringResource(id = R.string.in_dev),
				style = MaterialTheme.typography.bodyMedium,
				color = MaterialTheme.colorScheme.onSurface,
				textAlign = TextAlign.Center
			)
		}
	}
}
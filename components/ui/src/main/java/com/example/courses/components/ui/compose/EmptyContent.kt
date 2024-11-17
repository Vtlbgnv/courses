package com.example.courses.components.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.courses.components.ui.R

@Composable
fun EmptyContent(
	message: String = stringResource(id = R.string.empty_text),
	onRetryClick: (() -> Unit)? = null
) {
	Column(
		modifier = Modifier
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {

		Icon(
			painter = painterResource(id = R.drawable.ic_empty_folder),
			contentDescription = null,
			modifier = Modifier.size(64.dp)
		)

		Spacer(modifier = Modifier.height(16.dp))

		BaseText(
			text = message,
			style = MaterialTheme.typography.labelSmall
		)

		Spacer(modifier = Modifier.height(16.dp))


		if (onRetryClick != null) {
			Button(onClick = onRetryClick) {
				Text(text = stringResource(id = R.string.empty_button_text))
			}
		}
	}
}
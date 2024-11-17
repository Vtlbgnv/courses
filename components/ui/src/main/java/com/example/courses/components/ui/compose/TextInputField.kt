package com.example.courses.components.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courses.components.ui.theme.CoursesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(
	text: String,
	label: String,
	icon: ImageVector,
	onTextChange: (String) -> Unit,
	modifier: Modifier = Modifier,
	keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
	keyboardActions: KeyboardActions = KeyboardActions.Default,
	enabled: Boolean = true,
) {
	OutlinedTextField(
		value = text,
		onValueChange = onTextChange,
		enabled = enabled,
		keyboardOptions = keyboardOptions,
		keyboardActions = keyboardActions,
		placeholder = {
			Text(
				text = label,
				color = MaterialTheme.colorScheme.onSecondary
			)
		},
		leadingIcon = {
			Icon(
				imageVector = icon,
				contentDescription = null,
				tint = MaterialTheme.colorScheme.onSurface
			)
		},
		modifier = modifier
			.fillMaxWidth()
			.clip(RoundedCornerShape(28.dp))
			.background(color = MaterialTheme.colorScheme.surface),
		textStyle = MaterialTheme.typography.bodyLarge.copy(
			fontSize = 14.sp,
			letterSpacing = 0.25.sp,
			lineHeight = 18.sp,
		),
		colors = TextFieldDefaults.outlinedTextFieldColors(
			unfocusedBorderColor = Color.Transparent,
			focusedBorderColor = Color.Transparent,
			disabledBorderColor = Color.Transparent,
			errorBorderColor = Color.Transparent,
			containerColor = MaterialTheme.colorScheme.surface,
			cursorColor = MaterialTheme.colorScheme.primary,
		)
	)
}

@Preview
@Composable
private fun TextInputFieldPreview() {
	var text by remember { mutableStateOf("") }

	CoursesTheme {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.padding(horizontal = 16.dp),
			contentAlignment = Alignment.Center
		) {

		}
		TextInputField(
			text = text,
			icon = Icons.Default.Search,
			onTextChange = { text = it },
			label = "Search courses...",
			enabled = false,
			modifier = Modifier.padding(horizontal = 16.dp)
		)
	}

}


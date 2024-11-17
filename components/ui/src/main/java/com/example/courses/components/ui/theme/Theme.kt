package com.example.courses.components.ui.theme

import android.app.Activity
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp

private val darkColorScheme = darkColorScheme(
	primary = DarkPrimary,
	onSurface = DarkOnSurface,
	surface = DarkSurface,
	background = DarkBackground,
	onSecondary = DarkOnSecondary,
	surfaceContainer = DarkSurfaceContainer,
	outline = DarkOutline,
)

private val shapes = Shapes(
	extraSmall = RoundedCornerShape(8.dp),
	small = RoundedCornerShape(15.dp),
	medium = RoundedCornerShape(20.dp),
	large = RoundedCornerShape(28.dp),
)

@Composable
fun CoursesTheme(
	content: @Composable () -> Unit,
) {
	val colorScheme = darkColorScheme // TODO Добваить смену темы

	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			(view.context as? Activity)?.window?.apply {
				statusBarColor = android.graphics.Color.TRANSPARENT
				navigationBarColor = colorScheme.surface.toArgb()
			}
		}
	}

	MaterialTheme(
		colorScheme = colorScheme,
		typography = Typography,
		shapes = shapes,
		content = content,
	)
}
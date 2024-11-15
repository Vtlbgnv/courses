package com.example.courses.components.ui.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BaseText(
	text: String,
	style: TextStyle,
	modifier: Modifier = Modifier,
	textAlign: TextAlign? = null,
	textScale: Double = 1.0,
	color: Color = Color.Unspecified,
	maxLines: Int = Int.MAX_VALUE,
	overflow: TextOverflow = TextOverflow.Clip,
	softWrap: Boolean = true,
	onTextLayout: ((TextLayoutResult) -> Unit)? = null,
) {
	Text(
		text = text,
		modifier = modifier,
		color = color,
		textAlign = textAlign,
		maxLines = maxLines,
		overflow = overflow,
		softWrap = softWrap,
		onTextLayout = onTextLayout,
		style = style.copy(fontSize = style.fontSize * textScale),
	)
}
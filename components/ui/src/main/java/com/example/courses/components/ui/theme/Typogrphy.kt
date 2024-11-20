package com.example.courses.components.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.courses.components.ui.R

internal val robotoFontFamily = FontFamily(
	Font(R.font.roboto_light, FontWeight(300), FontStyle.Normal),
	Font(R.font.roboto_regular, FontWeight(400), FontStyle.Normal),
	Font(R.font.roboto_italic, FontWeight(400), FontStyle.Italic),
	Font(R.font.roboto_medium, FontWeight(500), FontStyle.Normal),
	Font(R.font.roboto_medium_italic, FontWeight(500), FontStyle.Italic),
	Font(R.font.roboto_semibold, FontWeight(600), FontStyle.Normal),
	Font(R.font.roboto_semibold_italic, FontWeight(600), FontStyle.Italic),
	Font(R.font.roboto_bold, FontWeight(700), FontStyle.Normal),
)

internal val Typography = Typography(
	titleLarge = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 24.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	titleMedium = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 22.sp,
		lineHeight = 28.sp,
		letterSpacing = 0.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	titleSmall = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 20.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	bodyLarge = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 16.sp,
		lineHeight = 18.sp,
		letterSpacing = 0.15.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	bodyMedium = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.4.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	bodySmall = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 12.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.4.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(400),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	labelLarge = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 20.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(600),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	labelMedium = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.4.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(600),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
	labelSmall = TextStyle(
		fontFamily = robotoFontFamily,
		fontSize = 12.sp,
		lineHeight = 15.sp,
		letterSpacing = 0.4.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(500),
		platformStyle = PlatformTextStyle(
			includeFontPadding = false,
		),
	),
)
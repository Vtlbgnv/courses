package com.example.courses.components.presentation.converter

import android.os.Build
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.TimeZone

fun formatDate(isoDate: String): String {
	val formattedDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
		val dateTime = ZonedDateTime.parse(isoDate)
		val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale("ru"))
		dateTime.format(formatter)
	} else {
		try {
			val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
			inputFormat.timeZone = TimeZone.getTimeZone("UTC")

			val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru"))
			val date = inputFormat.parse(isoDate) ?: throw IllegalArgumentException("Invalid date format")
			outputFormat.format(date)
		} catch (e: Exception) {
			e.printStackTrace()
			"Invalid date"
		}
	}
	return formattedDate.split(" ").joinToString(" ") { word ->
		if (word.all { it.isLetter() }) {
			word.replaceFirstChar { it.uppercaseChar() }
		} else {
			word
		}
	}
}
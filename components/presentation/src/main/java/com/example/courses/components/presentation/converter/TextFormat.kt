package com.example.courses.components.presentation.converter

import org.jsoup.Jsoup

fun textFormat(html: String): String {
	val document = Jsoup.parse(html)

	document.select("script, style").remove()

	val rawText = document.body().html()
		.replace("&nbsp;", " ")
		.replace(Regex("\\s+"), " ")
		.replace(Regex("<(br|p|div)[^>]*>"), "\n")
		.replace(Regex("</?(\\w+)[^>]*>"), "")
		.trim()

	return rawText.replace(Regex("\n\\s*\n+"), "\n\n")
}
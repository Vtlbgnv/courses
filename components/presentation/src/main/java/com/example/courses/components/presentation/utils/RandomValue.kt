package com.example.courses.components.presentation.utils

import java.text.DecimalFormat
import kotlin.math.round
import kotlin.random.Random

fun randomValue(): String {
	val randomValue = Random.nextDouble(2.0, 5.0)

	val roundedValue = round(randomValue * 10) / 10

	val decimalFormat = DecimalFormat("#.#")
	return decimalFormat.format(roundedValue)
}
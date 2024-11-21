package com.example.courses.shared.favorite.data.converters

import androidx.room.TypeConverter

class BooleanConverter {

	companion object {

		@TypeConverter
		@JvmStatic
		fun fromBoolean(value: Boolean): Int {
			return if (value) 1 else 0
		}

		@TypeConverter
		@JvmStatic
		fun toBoolean(value: Int): Boolean {
			return value != 0
		}
	}
}
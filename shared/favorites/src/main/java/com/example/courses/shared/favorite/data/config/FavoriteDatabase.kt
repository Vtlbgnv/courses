package com.example.courses.shared.favorite.data.config

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.courses.shared.favorite.data.converters.BooleanConverter
import com.example.courses.shared.favorite.data.dao.FavoriteDao
import com.example.courses.shared.favorite.data.model.FavoriteModel

@Database(
	entities = [
		FavoriteModel::class
	],
	version = 1,
)
@TypeConverters(BooleanConverter::class)
abstract class FavoriteDatabase : RoomDatabase() {

	abstract fun FavoriteDao(): FavoriteDao
}
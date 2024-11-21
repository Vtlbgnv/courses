package com.example.courses.shared.favorite.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.courses.shared.favorite.data.model.FavoriteModel

@Dao
interface FavoriteDao {

	@Transaction
	@Query("SELECT id FROM favorite")
	suspend fun getAllId(): List<Int>

	@Transaction
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun save(course: FavoriteModel)

	@Transaction
	@Query("SELECT * FROM favorite")
	suspend fun getAll(): List<FavoriteModel>

	@Transaction
	@Query("DELETE FROM favorite WHERE id = :id")
	suspend fun deleteById(id: Int)
}
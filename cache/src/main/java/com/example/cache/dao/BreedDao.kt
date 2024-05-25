package com.example.cache.dao

import androidx.room.*
import com.example.cache.models.BreedEntity
import com.example.cache.utils.CacheConstants

@Dao
interface BreedDao {
    @Query("select * from ${CacheConstants.BREED_TABLE_NAME}")
    suspend fun getBreeds():List<BreedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreed(vararg breed:BreedEntity)
}
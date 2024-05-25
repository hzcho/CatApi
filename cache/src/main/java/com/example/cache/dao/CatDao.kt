package com.example.cache.dao

import androidx.room.*
import com.example.cache.models.CatEntity
import com.example.cache.models.CatWithBreeds
import com.example.cache.utils.CacheConstants

@Dao
interface CatDao {
    @Transaction
    @Query("select * from ${CacheConstants.CAT_TABLE_NAME}")
    suspend fun getCats():List<CatWithBreeds>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCat(vararg catEntity: CatEntity)

    @Query("delete from ${CacheConstants.CAT_TABLE_NAME}")
    suspend fun deleteCats()

    @Query("delete from ${CacheConstants.BREED_TABLE_NAME}")
    suspend fun deleteBreeds()

    @Transaction
    suspend fun deleteAll(){
        deleteCats()
        deleteBreeds()
    }
}
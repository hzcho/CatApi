package com.example.cache.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.CAT_TABLE_NAME)
data class CatEntity(
    @PrimaryKey
    val id: String,
    val width: Int,
    val height: Int,
    val url: String
)

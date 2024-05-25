package com.example.data.repository

import com.example.data.models.CatEntity

interface CatCache {
    suspend fun getCats(): List<CatEntity>
    suspend fun saveCats(cats: List<CatEntity>)
    suspend fun deleteCats()
    suspend fun isCached(): Boolean
    suspend fun isExpired(): Boolean
    suspend fun setLastCashTime(time: Long)
}
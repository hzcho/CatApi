package com.example.data.repository

import com.example.data.models.CatEntity
import com.example.data.models.GetByPageParam

interface CatRemote {
    suspend fun getCats(param: GetByPageParam):List<CatEntity>
}
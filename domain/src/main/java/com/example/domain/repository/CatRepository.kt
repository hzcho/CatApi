package com.example.domain.repository

import com.example.domain.model.GetByPageParam
import com.example.domain.model.CatModel

interface CatRepository {
    //Remote
    suspend fun getCatsByPage(param: GetByPageParam):List<CatModel>

    //Cache
    suspend fun getSavedCats():List<CatModel>
    suspend fun saveCats(cats:List<CatModel>)
}
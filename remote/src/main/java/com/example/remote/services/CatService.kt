package com.example.remote.services

import com.example.remote.models.CatModel
import retrofit2.http.GET
import retrofit2.http.Query


interface CatService {
    @GET("images/search")
    suspend fun getCatsByPage(
        @Query("limit")
        limit:Int,
        @Query("page")
        page:Int
    ):List<CatModel>
}
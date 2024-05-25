package com.example.remote.repository_impl

import com.example.data.models.CatEntity
import com.example.data.models.GetByPageParam
import com.example.data.repository.CatRemote
import com.example.remote.mapper.CatMapper
import com.example.remote.services.CatService
import com.example.remote.utils.dataCat

class CatRemoteImpl(
    private val catService: CatService
):CatRemote {
    override suspend fun getCats(param: GetByPageParam): List<dataCat> {
        val response=catService.getCatsByPage(
            limit = param.limit,
            page = param.page
        )

        return response.map { CatMapper.mapFromRemote(it) }
    }
}
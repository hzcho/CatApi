package com.example.data.repository_impl

import com.example.data.mappers.CatMapper
import com.example.data.mappers.GetByPageParamMapper
import com.example.data.repository.CatCache
import com.example.data.repository.CatRemote
import com.example.domain.model.CatModel
import com.example.domain.model.GetByPageParam
import com.example.domain.repository.CatRepository

class CatRepositoryImpl(
    private val catCache:CatCache,
    private val catRemote:CatRemote
):CatRepository {
    override suspend fun getCatsByPage(param: GetByPageParam): List<CatModel> {
        val dataCats=catRemote.getCats(
            GetByPageParamMapper.mapToData(param)
        )
        val domainCats=dataCats.map { CatMapper.mapFromData(it) }

        catCache.deleteCats()
        catCache.saveCats(dataCats)
        catCache.setLastCashTime(System.currentTimeMillis())

        return domainCats
    }

    override suspend fun getSavedCats():List<CatModel> {
        val domainCats=catCache.getCats().map { CatMapper.mapFromData(it) }

        return domainCats
    }

    override suspend fun saveCats(cats: List<CatModel>) {
        val dataCats=cats.map { CatMapper.mapToData(it) }

        catCache.saveCats(dataCats)
    }
}
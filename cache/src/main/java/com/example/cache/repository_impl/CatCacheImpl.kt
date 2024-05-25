package com.example.cache.repository_impl

import com.example.cache.dao.BreedDao
import com.example.cache.dao.CatDao
import com.example.cache.mapper.CatWithBreedsMapper
import com.example.cache.utils.dataCat
import com.example.cache.utils.CacheConstants
import com.example.cache.utils.CachePreferencesHelper
import com.example.data.repository.CatCache

class CatCacheImpl(
    private val catDao:CatDao,
    private val breedDao: BreedDao,
    private val preferencesHelper: CachePreferencesHelper
):CatCache {
    override suspend fun getCats(): List<dataCat> {
        val dataCats=catDao.getCats().map { CatWithBreedsMapper.mapFromCache(it) }

        return dataCats
    }

    override suspend fun saveCats(cats: List<dataCat>) {
        val cacheCatsWithBreeds=cats.map { CatWithBreedsMapper.mapToCache(it) }

        cacheCatsWithBreeds.forEach {catWithBreeds->
            catDao.insertCat(catWithBreeds.cat)
            breedDao.insertBreed(*catWithBreeds.breeds.toTypedArray())
        }
    }

    override suspend fun deleteCats() {
        catDao.deleteAll()
    }

    override suspend fun isCached(): Boolean {
        return catDao.getCats().isNotEmpty()
    }

    override suspend fun isExpired(): Boolean {
        val currentTime=System.currentTimeMillis()
        val lastCachedTime=preferencesHelper.lastCacheTime

        val isExpired=currentTime-lastCachedTime > CacheConstants.EXPIRATION_TIME

        return isExpired
    }

    override suspend fun setLastCashTime(time: Long) {
        preferencesHelper.lastCacheTime=time
    }
}
package com.example.cache.mapper

import com.example.cache.utils.cacheCatWithBreeds
import com.example.cache.utils.dataCat

object CatWithBreedsMapper {
    fun mapFromCache(type: cacheCatWithBreeds): dataCat {
        return dataCat(
            id = type.cat.id,
            width = type.cat.width,
            height = type.cat.height,
            url = type.cat.url,
            breeds =type.breeds.map { BreedMapper.mapFromCache(it) }
        )
    }

    fun mapToCache(type: dataCat): cacheCatWithBreeds {
        return cacheCatWithBreeds(
            cat =CatMapper.mapToCache(type),
            breeds = type.breeds?.map { BreedMapper.mapToCache(it, type.id) } ?: emptyList()
        )
    }
}
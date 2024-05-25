package com.example.cache.mapper

import com.example.cache.utils.cacheCat
import com.example.cache.utils.dataCat

object CatMapper {
    fun mapToCache(type: dataCat): cacheCat {
        return cacheCat(
            id = type.id,
            height = type.height,
            width = type.width,
            url = type.url
        )
    }
}
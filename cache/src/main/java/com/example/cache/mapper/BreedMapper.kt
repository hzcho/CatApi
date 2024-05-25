package com.example.cache.mapper

import com.example.cache.utils.cacheBreed
import com.example.cache.utils.dataBreed

object BreedMapper {
    fun mapFromCache(type: cacheBreed): dataBreed {
        return dataBreed(
            weight = WeightMapper.mapFromCache(type.weight),
            id = type.id,
            name = type.name,
            temperament = type.temperament,
            origin = type.origin,
            country_codes = type.country_codes,
            country_code = type.country_code,
            life_span = type.life_span,
            wikipedia_url = type.wikipedia_url
        )
    }

    fun mapToCache(type: dataBreed, catId:String): cacheBreed {
        return cacheBreed(
            weight = WeightMapper.mapToCache(type.weight),
            id = type.id,
            name = type.name,
            temperament = type.temperament,
            origin = type.origin,
            country_codes = type.country_codes,
            country_code = type.country_code,
            life_span = type.life_span,
            wikipedia_url = type.wikipedia_url,
            catId=catId
        )
    }
}
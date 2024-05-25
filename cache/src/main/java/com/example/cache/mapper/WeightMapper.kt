package com.example.cache.mapper

import com.example.cache.utils.cacheWeight
import com.example.cache.utils.dataWeight

object WeightMapper {
    fun mapFromCache(type: cacheWeight): dataWeight {
        return dataWeight(
            imperial = type.imperial,
            metric = type.metric
        )
    }

    fun mapToCache(type: dataWeight): cacheWeight {
        return cacheWeight(
            imperial = type.imperial,
            metric = type.metric
        )
    }
}
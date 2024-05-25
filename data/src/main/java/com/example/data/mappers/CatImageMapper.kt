package com.example.data.mappers

import com.example.data.utils.dataCatImage
import com.example.data.utils.domainCatImage

internal object CatImageMapper:DataMapper<dataCatImage, domainCatImage> {
    override fun mapFromData(type: dataCatImage): domainCatImage {
        return domainCatImage(
            id = type.id,
            url = type.url
        )
    }

    override fun mapToData(type: domainCatImage): dataCatImage {
        return dataCatImage(
            id = type.id,
            url = type.url
        )
    }
}
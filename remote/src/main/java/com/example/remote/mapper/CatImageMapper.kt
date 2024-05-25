package com.example.remote.mapper

import com.example.remote.utils.dataCatImage
import com.example.remote.utils.remoteCat
import com.example.remote.utils.remoteCatImage

internal object CatImageMapper:RemoteMapper<remoteCatImage, dataCatImage> {
    override fun mapFromRemote(type: remoteCatImage): dataCatImage {
        return dataCatImage(
            id = type.id,
            url = type.url
        )
    }
}
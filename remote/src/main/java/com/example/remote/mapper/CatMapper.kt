package com.example.remote.mapper

import com.example.data.models.CatEntity
import com.example.remote.models.CatModel
import com.example.remote.utils.dataCat
import com.example.remote.utils.remoteCat

internal object CatMapper : RemoteMapper<remoteCat, dataCat> {
    override fun mapFromRemote(type: remoteCat): dataCat {
        return dataCat(
            id = type.id,
            width = type.width,
            height = type.height,
            url = type.url,
            breeds = type.breedModels?.map { BreedMapper.mapFromRemote(it) }
        )
    }
}
package com.example.data.mappers

import com.example.data.models.CatEntity
import com.example.data.utils.dataCat
import com.example.data.utils.domainCat
import com.example.domain.model.CatModel

internal object CatMapper:DataMapper<dataCat, domainCat> {
    override fun mapFromData(type: dataCat): domainCat {
        return domainCat(
            id = type.id,
            width =type.width,
            height = type.height,
            url = type.url,
            breeds = type.breeds?.map { BreedMapper.mapFromData(it) }
        )
    }

    override fun mapToData(type: domainCat): dataCat {
        return dataCat(
            id = type.id,
            width =type.width,
            height = type.height,
            url = type.url,
            breeds = type.breeds?.map { BreedMapper.mapToData(it) }
        )
    }
}
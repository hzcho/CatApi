package com.example.remote.mapper

import com.example.data.models.BreedEntity
import com.example.remote.models.BreedModel
import com.example.remote.utils.dataBreed
import com.example.remote.utils.remoteBreed

internal object BreedMapper : RemoteMapper<remoteBreed, dataBreed> {
    override fun mapFromRemote(type: remoteBreed): dataBreed {
        return dataBreed(
            weight = WeightMapper.mapFromRemote(type.weight),
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
}
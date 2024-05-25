package com.example.data.mappers

import com.example.data.models.BreedEntity
import com.example.data.utils.dataBreed
import com.example.data.utils.domainBreed
import com.example.domain.model.Breed

internal object BreedMapper:DataMapper<dataBreed, domainBreed> {
    override fun mapFromData(type:dataBreed):domainBreed{
        return domainBreed(
            weight = WeightMapper.mapFromData(type.weight),
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

    override fun mapToData(type: domainBreed): dataBreed {
        return dataBreed(
            weight = WeightMapper.mapToData(type.weight),
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
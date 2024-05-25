package com.example.data.mappers

import com.example.data.models.WeightEntity
import com.example.data.utils.dataWeight
import com.example.data.utils.domainWeight
import com.example.domain.model.Weight

internal object WeightMapper:DataMapper<dataWeight, domainWeight> {
    override fun mapFromData(type:dataWeight):domainWeight{
        return domainWeight(
            imperial = type.imperial,
            metric = type.metric
        )
    }

    override fun mapToData(type: domainWeight): dataWeight {
        return dataWeight(
            imperial = type.imperial,
            metric = type.metric
        )
    }
}
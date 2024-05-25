package com.example.data.mappers

import com.example.data.utils.dataVote
import com.example.data.utils.domainVote
import com.example.domain.model.VoteModel

internal object VoteMapper:DataMapper<dataVote, domainVote> {
    override fun mapFromData(type: dataVote): domainVote {
        return domainVote(
            id =type.id,
            imageId =type.imageId,
            subId =type.subId,
            createdAt =type.createdAt,
            value =type.value,
            countryCode =type.countryCode,
            image =CatImageMapper.mapFromData(type.image)
        )
    }

    override fun mapToData(type: domainVote): dataVote {
        return dataVote(
            id =type.id,
            imageId =type.imageId,
            subId =type.subId,
            createdAt =type.createdAt,
            value =type.value,
            countryCode =type.countryCode,
            image =CatImageMapper.mapToData(type.image)
        )
    }

}
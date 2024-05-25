package com.example.remote.mapper

import com.example.remote.utils.dataVote
import com.example.remote.utils.remoteVote

internal object VoteMapper:RemoteMapper<remoteVote, dataVote> {

    override fun mapFromRemote(type: remoteVote): dataVote {
        return dataVote(
            id =type.id,
            imageId =type.imageId,
            subId =type.subId,
            createdAt =type.createdAt,
            value =type.value,
            countryCode =type.countryCode,
            image = CatImageMapper.mapFromRemote(type.image)
        )
    }
}
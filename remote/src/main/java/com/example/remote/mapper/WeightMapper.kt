package com.example.remote.mapper

import com.example.data.models.WeightEntity
import com.example.remote.models.WeightModel
import com.example.remote.utils.dataWeight
import com.example.remote.utils.remoteWeight

internal object WeightMapper:RemoteMapper<remoteWeight, dataWeight> {
    override fun mapFromRemote(type: remoteWeight): dataWeight {
        return dataWeight(
            imperial = type.imperial,
            metric = type.metric
        )
    }
}
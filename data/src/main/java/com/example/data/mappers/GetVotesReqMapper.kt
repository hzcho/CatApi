package com.example.data.mappers

import com.example.data.utils.dataGetVotesReq
import com.example.data.utils.domainGetVotesReq

internal object GetVotesReqMapper {
    fun mapToData(type:domainGetVotesReq):dataGetVotesReq{
        return dataGetVotesReq(
            sub_id = type.sub_id
        )
    }
}
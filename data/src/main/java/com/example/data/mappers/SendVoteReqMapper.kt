package com.example.data.mappers

import com.example.data.utils.dataSendVoteReq
import com.example.data.utils.domainSendVoteReq
import com.example.domain.model.SendVoteRequest

internal object SendVoteReqMapper : DataMapper<dataSendVoteReq, domainSendVoteReq> {
    override fun mapFromData(type: dataSendVoteReq): domainSendVoteReq {
        return domainSendVoteReq(
            image_id = type.image_id,
            sub_id = type.sub_id,
            value = type.value
        )
    }

    override fun mapToData(type: domainSendVoteReq): dataSendVoteReq {
        return dataSendVoteReq(
            image_id = type.image_id,
            sub_id = type.sub_id,
            value = type.value
        )
    }
}
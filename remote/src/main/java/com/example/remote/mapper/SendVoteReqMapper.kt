package com.example.remote.mapper

import com.example.remote.utils.dataSendVoteReq
import com.example.remote.utils.remoteSendVoteReq

object SendVoteReqMapper {
    fun mapToRemote(type:dataSendVoteReq):remoteSendVoteReq{
        return remoteSendVoteReq(
            image_id = type.image_id,
            sub_id = type.sub_id,
            value = type.value
        )
    }
}
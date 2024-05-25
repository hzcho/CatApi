package com.example.remote.repository_impl

import android.util.Log
import com.example.data.models.GetVotesRequest
import com.example.data.models.SendVoteRequest
import com.example.data.models.VoteEntity
import com.example.data.repository.VoteRemote
import com.example.remote.mapper.SendVoteReqMapper
import com.example.remote.mapper.VoteMapper
import com.example.remote.services.VoteService

class VoteRemoteImpl(
    private val voteService: VoteService
):VoteRemote {
    override suspend fun getVotes(param: GetVotesRequest): List<VoteEntity> {
        val remoteVotes=voteService.getVotes(
            sub_id = param.sub_id
        )

        val dataVotes=remoteVotes.map { VoteMapper.mapFromRemote(it) }

        return dataVotes
    }

    override suspend fun sendVote(param: SendVoteRequest) {
        val remoteParam=SendVoteReqMapper.mapToRemote(param)

        voteService.sendVote(
            sendVoteRequest = remoteParam
        )
    }
}
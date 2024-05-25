package com.example.data.repository_impl

import com.example.data.mappers.GetByPageParamMapper
import com.example.data.mappers.GetVotesReqMapper
import com.example.data.mappers.SendVoteReqMapper
import com.example.data.mappers.VoteMapper
import com.example.data.repository.VoteRemote
import com.example.domain.model.CatImage
import com.example.domain.model.GetVotesRequest
import com.example.domain.model.SendVoteRequest
import com.example.domain.model.VoteModel
import com.example.domain.repository.VoteRepository

class VoteRepositoryImpl(
    private val voteRemote: VoteRemote
):VoteRepository {
    override suspend fun getVotes(getVotesRequest: GetVotesRequest): List<VoteModel> {
        val dataVotes=voteRemote.getVotes(
            param = GetVotesReqMapper.mapToData(getVotesRequest)
        )
        val domainVotes=dataVotes.map { VoteMapper.mapFromData(it) }

        return domainVotes
    }

    override suspend fun sendVote(sendVoteRequest: SendVoteRequest) {
        voteRemote.sendVote(
            param = SendVoteReqMapper.mapToData(sendVoteRequest)
        )
    }
}
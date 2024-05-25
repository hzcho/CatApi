package com.example.domain.repository

import com.example.domain.model.GetVotesRequest
import com.example.domain.model.SendVoteRequest
import com.example.domain.model.VoteModel

interface VoteRepository {
    suspend fun getVotes(getVotesRequest:GetVotesRequest):List<VoteModel>
    suspend fun sendVote(sendVoteRequest: SendVoteRequest)
}
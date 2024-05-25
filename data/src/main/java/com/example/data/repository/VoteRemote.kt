package com.example.data.repository

import com.example.data.models.GetVotesRequest
import com.example.data.models.SendVoteRequest
import com.example.data.models.VoteEntity
import com.example.data.utils.dataSendVoteReq

interface VoteRemote {
    suspend fun getVotes(param:GetVotesRequest):List<VoteEntity>
    suspend fun sendVote(param: SendVoteRequest)
}
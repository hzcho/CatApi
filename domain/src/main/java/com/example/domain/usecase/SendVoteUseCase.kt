package com.example.domain.usecase

import com.example.domain.model.SendVoteRequest
import com.example.domain.repository.VoteRepository

class SendVoteUseCase(private val voteRepository:VoteRepository):BaseUseCase<SendVoteRequest, Unit> {

    override suspend fun invoke(param: SendVoteRequest) {
        return voteRepository.sendVote(param)
    }
}
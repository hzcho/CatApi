package com.example.domain.usecase

import com.example.domain.model.GetVotesRequest
import com.example.domain.model.VoteModel
import com.example.domain.repository.VoteRepository

class GetVotesUseCase(private val voteRepository: VoteRepository):BaseUseCase<GetVotesRequest, List<VoteModel>> {

    override suspend fun invoke(param: GetVotesRequest):List<VoteModel> {
        return voteRepository.getVotes(param)
    }
}
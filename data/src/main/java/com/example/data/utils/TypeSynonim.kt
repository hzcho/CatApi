package com.example.data.utils

import com.example.data.models.*
import com.example.data.models.GetByPageParam
import com.example.data.models.SendVoteRequest
import com.example.domain.model.*
import com.example.domain.model.GetVotesRequest

//Data
internal typealias dataBreed= BreedEntity
internal typealias dataCat= CatEntity
internal typealias dataGetParam= GetByPageParam
internal typealias dataWeight= WeightEntity
internal typealias dataGetVotesReq=com.example.data.models.GetVotesRequest
internal typealias dataSendVoteReq=SendVoteRequest
internal typealias dataVote=VoteEntity
internal typealias dataCatImage=CatImageEntity

//Domain
internal typealias domainBreed= Breed
internal typealias domainCat= CatModel
internal typealias domainGetParam=com.example.domain.model.GetByPageParam
internal typealias domainWeight= Weight
internal typealias domainGetVotesReq=GetVotesRequest
internal typealias domainSendVoteReq=com.example.domain.model.SendVoteRequest
internal typealias domainVote=VoteModel
internal typealias domainCatImage=CatImage
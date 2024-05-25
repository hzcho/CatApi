package com.example.remote.services

import com.example.remote.models.SendVoteRequest
import com.example.remote.models.VoteModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

private const val API_KEY="live_Kmhql82EPhbIdCQH3wWIO1CQHgyXd09CuoCpfXe4qIwCbLkW0PDDruyNfanXIjsm"

interface VoteService {
    @Headers(
        "Content-Type: application/json",
        "x-api-key: $API_KEY"
    )
    @GET("votes")
    suspend fun getVotes(@Query("sub_id") sub_id:String):List<VoteModel>

    @Headers(
        "Content-Type: application/json",
        "x-api-key: $API_KEY"
    )
    @POST("votes")
    suspend fun sendVote(@Body sendVoteRequest: SendVoteRequest)
}
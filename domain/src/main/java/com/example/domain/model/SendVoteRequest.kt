package com.example.domain.model

data class SendVoteRequest(
    val image_id:String,
    val sub_id:String,
    val value:Int
)
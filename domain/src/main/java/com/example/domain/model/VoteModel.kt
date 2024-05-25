package com.example.domain.model

import java.util.*

data class VoteModel(
    val id: Int,
    val imageId: String,
    val subId: String,
    val createdAt: Date,
    val value: Int,
    val countryCode: String,
    val image: CatImage
)

data class CatImage(
    val id: String,
    val url: String
)

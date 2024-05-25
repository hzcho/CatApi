package com.example.data.models

import java.util.*

data class VoteEntity(
    val id: Int,
    val imageId: String,
    val subId: String,
    val createdAt: Date,
    val value: Int,
    val countryCode: String,
    val image: CatImageEntity
)

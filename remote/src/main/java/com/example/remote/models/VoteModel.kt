package com.example.remote.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class VoteModel(
    val id: Int,
    @SerializedName("image_id")
    val imageId: String,
    @SerializedName("sub_id")
    val subId: String,
    @SerializedName("created_at")
    val createdAt: Date,
    val value: Int,
    @SerializedName("country_code")
    val countryCode: String,
    val image: CatImageModel
)

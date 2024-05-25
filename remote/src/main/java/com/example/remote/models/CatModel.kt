package com.example.remote.models

data class CatModel(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val breedModels: List<BreedModel>?
)

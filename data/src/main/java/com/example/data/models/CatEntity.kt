package com.example.data.models

data class CatEntity(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val breeds: List<BreedEntity>?
)

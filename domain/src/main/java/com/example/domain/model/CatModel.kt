package com.example.domain.model

data class CatModel(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val breeds: List<Breed>?
)

data class Breed(
    val weight: Weight,
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,
    val life_span: String,
    val wikipedia_url: String
)

data class Weight(
    val imperial: String,
    val metric: String
)


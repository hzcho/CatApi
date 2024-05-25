package com.example.data.models

data class BreedEntity(
    val weight: WeightEntity,
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,
    val life_span: String,
    val wikipedia_url: String
)
package com.example.remote.models

data class BreedModel(
    val weight: WeightModel,
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,
    val life_span: String,
    val wikipedia_url: String
)
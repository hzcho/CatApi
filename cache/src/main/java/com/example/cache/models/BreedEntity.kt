package com.example.cache.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.BREED_TABLE_NAME)
data class BreedEntity(
    @Embedded
    val weight: WeightEntity,
    @PrimaryKey
    val id: String,
    val name: String,
    val temperament: String,
    val origin: String,
    val country_codes: String,
    val country_code: String,
    val life_span: String,
    val wikipedia_url: String,
    val catId:String
)
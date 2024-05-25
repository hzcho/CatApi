package com.example.cache.models

import androidx.room.Embedded
import androidx.room.Relation

data class CatWithBreeds(
    @Embedded
    val cat: CatEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "catId"
    )
    val breeds: List<BreedEntity>
)

package com.example.domain.usecase

import com.example.domain.model.CatModel
import com.example.domain.repository.CatRepository

class GetSavedCatsUseCase(private val catRepository: CatRepository):BaseUseCase<Unit, List<CatModel>> {

    override suspend fun invoke(param: Unit): List<CatModel> {
        return catRepository.getSavedCats()
    }
}
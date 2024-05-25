package com.example.domain.usecase

import com.example.domain.model.GetByPageParam
import com.example.domain.model.CatModel
import com.example.domain.repository.CatRepository

class GetCatsByPage(private val catRepository: CatRepository):BaseUseCase<GetByPageParam, List<CatModel>> {

    override suspend fun invoke(param: GetByPageParam): List<CatModel> {
        return catRepository.getCatsByPage(param)
    }
}
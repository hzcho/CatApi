package com.example.catapi.di

import com.example.domain.repository.CatRepository
import com.example.domain.repository.VoteRepository
import com.example.domain.usecase.GetCatsByPage
import com.example.domain.usecase.GetSavedCatsUseCase
import com.example.domain.usecase.GetVotesUseCase
import com.example.domain.usecase.SendVoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideGetCatsByPageUseCase(catRepository: CatRepository):GetCatsByPage{
        return GetCatsByPage(catRepository = catRepository)
    }

    @Provides
    @Singleton
    fun provideSendVoteUseCase(voteRepository: VoteRepository):SendVoteUseCase{
        return SendVoteUseCase(voteRepository=voteRepository)
    }

    @Provides
    @Singleton
    fun provideGetSavedCatsUseCase(catRepository: CatRepository):GetSavedCatsUseCase{
        return GetSavedCatsUseCase(catRepository=catRepository)
    }

    @Provides
    @Singleton
    fun provideGetVotesUseCase(voteRepository: VoteRepository):GetVotesUseCase{
        return GetVotesUseCase(voteRepository=voteRepository)
    }
}
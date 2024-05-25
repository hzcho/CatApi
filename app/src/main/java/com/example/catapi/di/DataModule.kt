package com.example.catapi.di

import com.example.data.repository.CatCache
import com.example.data.repository.CatRemote
import com.example.data.repository.VoteRemote
import com.example.data.repository_impl.CatRepositoryImpl
import com.example.data.repository_impl.VoteRepositoryImpl
import com.example.domain.repository.CatRepository
import com.example.domain.repository.VoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCatRepository(catCache:CatCache, catRemote: CatRemote):CatRepository{
        return CatRepositoryImpl(
            catCache = catCache,
            catRemote = catRemote
        )
    }

    @Provides
    @Singleton
    fun provideVoteRepository(voteRemote: VoteRemote):VoteRepository{
        return VoteRepositoryImpl(
            voteRemote = voteRemote
        )
    }
}
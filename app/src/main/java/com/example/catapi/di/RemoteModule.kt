package com.example.catapi.di

import com.example.data.repository.CatRemote
import com.example.data.repository.VoteRemote
import com.example.remote.repository_impl.CatRemoteImpl
import com.example.remote.repository_impl.VoteRemoteImpl
import com.example.remote.services.CatService
import com.example.remote.services.VoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        val interceptor= HttpLoggingInterceptor().apply {
            level= HttpLoggingInterceptor.Level.BODY
        }

        val client= OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit= Retrofit
            .Builder()
            .client(client)
            .baseUrl(" https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    @Provides
    @Singleton
    fun provideCatService(retrofit: Retrofit): CatService {
        return retrofit.create(CatService::class.java)
    }

    @Provides
    @Singleton
    fun provideCatRemote(catService:CatService):CatRemote{
        return CatRemoteImpl(
            catService = catService
        )
    }

    @Provides
    @Singleton
    fun provideVoteService(retrofit: Retrofit):VoteService{
        return retrofit.create(VoteService::class.java)
    }

    @Provides
    @Singleton
    fun provideVoteRemote(voteService: VoteService):VoteRemote{
        return VoteRemoteImpl(
            voteService=voteService
        )
    }
}
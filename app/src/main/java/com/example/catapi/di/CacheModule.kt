package com.example.catapi.di

import android.app.Application
import androidx.room.Room
import com.example.cache.dao.BreedDao
import com.example.cache.dao.CatDao
import com.example.cache.database.MainDb
import com.example.cache.repository_impl.CatCacheImpl
import com.example.cache.utils.CachePreferencesHelper
import com.example.data.repository.CatCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun provideMainDb(app:Application):MainDb{
        return MainDb.getInstance(
            context = app
        )
    }

    @Singleton
    @Provides
    fun provideCachePreferencesHelper(app: Application):CachePreferencesHelper{
        return CachePreferencesHelper(
            context = app
        )
    }

    @Provides
    @Singleton
    fun provideCatCache(mainDb: MainDb, cachePreferencesHelper: CachePreferencesHelper):CatCache{
        return CatCacheImpl(
            catDao = mainDb.catDao,
            breedDao=mainDb.breedDao,
            preferencesHelper = cachePreferencesHelper)
    }
}
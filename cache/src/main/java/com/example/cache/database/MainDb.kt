package com.example.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cache.dao.BreedDao
import com.example.cache.dao.CatDao
import com.example.cache.models.BreedEntity
import com.example.cache.models.CatEntity
import com.example.cache.utils.CacheConstants

@Database(
    entities = [
        CatEntity::class,
        BreedEntity::class
    ],
    version = 1
)
abstract class MainDb:RoomDatabase() {
    abstract val catDao:CatDao
    abstract val breedDao:BreedDao

    companion object{
        @Volatile
        private var INSTANCE:MainDb?=null

        fun getInstance(context: Context)= synchronized(this){
            INSTANCE ?: createDatabase(context).apply {
                INSTANCE=this
            }
        }

        private fun createDatabase(context:Context)=Room.databaseBuilder(
            context = context,
            klass = MainDb::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}
package com.example.cache.utils

object CacheConstants {
    const val DB_NAME="main_db"
    const val CAT_TABLE_NAME="cats"
    const val BREED_TABLE_NAME="breeds"

    //the time after which the database needs to be updated
    const val EXPIRATION_TIME=(60 * 10 * 1000).toLong()
}
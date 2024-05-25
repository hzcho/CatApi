package com.example.cache.utils

import android.content.Context
import android.content.SharedPreferences

class CachePreferencesHelper(context: Context) {
    companion object{
        const val PREF_NAME="pref_name"
        const val LAST_CACHE_KEY="last_cache_key"
    }

    private val preference:SharedPreferences=
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var lastCacheTime:Long
        get() =preference.getLong(LAST_CACHE_KEY, 0)
        set(value) = preference.edit().putLong(LAST_CACHE_KEY, value).apply()
}
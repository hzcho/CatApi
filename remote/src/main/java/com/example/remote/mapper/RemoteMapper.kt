package com.example.remote.mapper

interface RemoteMapper<E,D> {
    fun mapFromRemote(type:E):D
}
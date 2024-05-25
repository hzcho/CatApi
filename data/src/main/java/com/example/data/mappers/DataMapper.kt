package com.example.data.mappers

interface DataMapper<E, D> {
    fun mapFromData(type: E): D
    fun mapToData(type: D): E
}
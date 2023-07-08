package com.example.triviagame.data.source.local


interface DataStorePref {
    suspend fun savePoints(points: String)
    fun getPoints(): String?
    suspend fun clearPoints()
}
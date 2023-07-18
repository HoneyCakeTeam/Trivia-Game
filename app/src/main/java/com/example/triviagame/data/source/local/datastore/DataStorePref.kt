package com.example.triviagame.data.source.local.datastore


interface DataStorePref {
    suspend fun savePoints(points: Int)
    fun getPoints(): String?
    suspend fun clearPoints()
}
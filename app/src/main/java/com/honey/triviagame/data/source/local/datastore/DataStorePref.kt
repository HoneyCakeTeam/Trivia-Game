package com.honey.triviagame.data.source.local.datastore


interface DataStorePref {
    suspend fun saveHighestScore(points: Int)
    fun getHighestScore(): Int?
    suspend fun clearHighestScore()
}
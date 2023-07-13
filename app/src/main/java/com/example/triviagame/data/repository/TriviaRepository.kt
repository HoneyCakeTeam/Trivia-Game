package com.example.triviagame.data.repository

import com.example.triviagame.data.source.remote.model.QuestionDto


interface TriviaRepository {
    suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionDto>

    suspend fun savePints(points: Int)
    fun getPoints(): String?
}
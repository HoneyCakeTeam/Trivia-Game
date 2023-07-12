package com.example.triviagame.data.source.remote.network

import com.example.triviagame.data.source.remote.model.QuestionModel

interface TriviaService {
    suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionModel>
}
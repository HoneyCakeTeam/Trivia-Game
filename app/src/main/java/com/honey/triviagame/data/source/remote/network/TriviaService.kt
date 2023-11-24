package com.honey.triviagame.data.source.remote.network

import com.honey.triviagame.data.source.remote.model.QuestionDto

interface TriviaService {
    suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionDto>
}
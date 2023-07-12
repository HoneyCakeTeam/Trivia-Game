package com.example.triviagame.data.repository

import com.example.triviagame.data.source.remote.model.QuestionModel

interface TriviaRepository {
    suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ):List<QuestionModel>
}
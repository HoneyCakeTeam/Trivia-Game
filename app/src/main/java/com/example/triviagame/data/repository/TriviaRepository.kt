package com.example.triviagame.data.repository

import com.example.triviagame.data.source.remote.model.QuestionDto
import com.example.triviagame.ui.screens.play.QuestionUiState


interface TriviaRepository {
    suspend fun getTriviaQuestions(
        category: String,
        difficulty: String,
    ): List<QuestionDto>

    suspend fun savePints(points: Int)
    fun getPoints(): String?

    fun removeAt(index: Int)
    fun clearCache()
    fun getQuestionByIndex(index: Int): QuestionUiState
    fun cacheQuestions(questions: List<QuestionUiState>)
}
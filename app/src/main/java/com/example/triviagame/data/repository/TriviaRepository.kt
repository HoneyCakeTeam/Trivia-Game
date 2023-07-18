package com.example.triviagame.data.repository

import com.example.triviagame.data.entity.AnswerEntity
import com.example.triviagame.data.entity.QuestionEntity
import com.example.triviagame.ui.screens.answer_details.AnswerUiState


interface TriviaRepository {
    suspend fun refreshTriviaQuestions(
        category: String,
        difficulty: String,
    )

    suspend fun saveHighestScore(points: Int)
    fun getHighestScore(): Int

    fun removeQuestionAt(index: Int)
    fun clearQuestionsCache()
    fun getQuestionByIndex(index: Int): QuestionEntity
    fun cacheQuestions(questions: List<QuestionEntity>)

    fun putQuestionAnswer(key: Int, value: AnswerUiState)
    fun removeQuestionAnswer(key: Int)
    fun clearAllQuestionAnswers()
    fun getQuestionAnswers(): List<AnswerEntity>
    fun getSkippedAnswersCount(): Int
    fun getIncorrectAnswersCount(): Int
    fun getCorrectAnswersCount(): Int
}
package com.example.triviagame.ui.screens.answer_details

import com.example.triviagame.data.entity.AnswerEntity
import com.example.triviagame.ui.util.QuestionState

data class AnswersUiState(
    val questions: List<AnswerUiState> = emptyList(),
    val totalQuestions: Int = 10,
    val totalAnswers: Int = 0,
    val correctAnswersCount: Int = 0,
)

data class AnswerUiState(
    val state: QuestionState = QuestionState.NOT_ANSWERED,
    val questionText: String = "",
    val userAnswer: String = "",
    val correctAnswer: String = "",
)

fun AnswerEntity.toAnswerUiState() =
    AnswerUiState(
        state = state,
        questionText = questionText,
        userAnswer = userAnswer,
        correctAnswer = correctAnswer
    )

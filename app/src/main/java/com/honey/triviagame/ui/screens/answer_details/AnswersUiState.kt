package com.honey.triviagame.ui.screens.answer_details

import com.honey.triviagame.data.entity.AnswerEntity
import com.honey.triviagame.ui.util.QuestionState

data class AnswersUiState(
    val questions: List<AnswerUiState> = emptyList(),
    val totalQuestions: Int = 10,
    val correctAnswersCount: Int = 0,
    val correctAnswersPercentage: Int = 0,
    val inCorrectAnswersPercentage: Int = 0,
)

data class AnswerUiState(
    val state: QuestionState = QuestionState.NOT_ANSWERED,
    val questionText: String = "",
    val userAnswer: String = "",
    val correctAnswer: String = "",
    val type: String = "Science",
)

fun AnswerEntity.toAnswerUiState() =
    AnswerUiState(
        state = state,
        questionText = questionText,
        userAnswer = userAnswer,
        correctAnswer = correctAnswer,
        type = type
    )

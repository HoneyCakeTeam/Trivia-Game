package com.example.triviagame.data.entity

import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.util.QuestionState

data class AnswerEntity(
    val state: QuestionState = QuestionState.NOT_ANSWERED,
    val questionText: String = "",
    val userAnswer: String = "",
    val correctAnswer: String = "",
    val type:String = ""
)

fun AnswerUiState.toAnswerEntity() =
    AnswerEntity(
        state = state,
        questionText = questionText,
        userAnswer = userAnswer,
        correctAnswer = correctAnswer,
        type = type
    )

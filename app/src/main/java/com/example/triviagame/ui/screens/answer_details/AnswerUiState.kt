package com.example.triviagame.ui.screens.answer_details

import com.example.triviagame.ui.util.QuestionState

data class AnswerUiState(
    val id: Int = 0,
    val state: QuestionState =QuestionState.NOT_ANSWERED,
    val question: String = "",
    val answer: String = "",
    val totalQuestions: Int = 10,
    val totalAnswers: Int = 8
)

package com.example.triviagame.ui.screens.answer_details

import com.example.triviagame.ui.util.QuestionState

data class AnswerUiState(
    val id:Int,
    val state: QuestionState,
    val question: String,
    val answer: String,
)

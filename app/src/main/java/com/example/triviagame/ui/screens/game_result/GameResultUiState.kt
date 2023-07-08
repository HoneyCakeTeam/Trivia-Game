package com.example.triviagame.ui.screens.game_result

data class GameResultUiState(
    val textResult: String = "",
    val answerCardText: String = "",
    val answerCardIconResId: Int = 0,
    val correctQuestionCount: String = "",
    val completionQuestionCount: String = "",
    val skippedQuestionCount: String = "",
    val incorrectQuestionCount: String = ""
)

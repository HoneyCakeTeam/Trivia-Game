package com.example.triviagame.ui.screens.game_result

data class GameResultUiState(
    /*val textResult: String = "",
    val answerCardText: String = "",
    val answerCardIconResId: Int = 0,
    val correctQuestionCount: String = "",
    val completionQuestionCount: String = "",
    val skippedQuestionCount: String = "",
    val incorrectQuestionCount: String = ""*/
    val totalQuestions: Int = 10,
    val totalAnswers: Int = 0,
    val correctAnswersCount: Int = 0,
    val skippedAnswersCount: Int = 0,
    val incorrectAnswersCount: Int = 0,
)

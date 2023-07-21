package com.example.triviagame

sealed class Screen(val rout: String) {
    object Categories : Screen("categories")
    object PlayScreen : Screen("PlayScreen")
    object GameResultScreen : Screen("gameResultScreen")
    object AnswerDetails : Screen("answerDetails")
}
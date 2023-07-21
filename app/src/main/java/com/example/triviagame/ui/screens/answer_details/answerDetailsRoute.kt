package com.example.triviagame.ui.screens.answer_details

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "answerDetails"

fun NavGraphBuilder.answerDetailsRoute() {
    composable(route = ROUTE) {
        AnswerDetailsScreen()
    }
}

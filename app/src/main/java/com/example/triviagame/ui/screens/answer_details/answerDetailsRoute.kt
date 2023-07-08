package com.example.triviagame.ui.screens.answer_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "answerDetails"

fun NavGraphBuilder.answerDetailsRoute(navController: NavController) {
    composable(route = ROUTE) {
        AnswerDetailsScreen(navController)
    }
}

package com.example.triviagame.ui.screens.answer_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.triviagame.ui.LocalNavigationProvider

private const val ROUTE = "answerDetails"

fun NavGraphBuilder.answerDetailsRoute() {
    composable(route = ROUTE) {
        AnswerDetailsScreen()
    }
}

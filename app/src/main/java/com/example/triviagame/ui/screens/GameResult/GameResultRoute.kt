package com.example.triviagame.ui.screens.GameResult

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "gameResult"

fun NavGraphBuilder.gameResultRoute(navController: NavController) {

    composable(route = ROUTE) {
        GameScreen(navController)

    }
}

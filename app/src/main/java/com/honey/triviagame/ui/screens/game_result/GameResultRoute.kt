package com.honey.triviagame.ui.screens.game_result

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "gameResult"


fun NavController.navigateToGameResult() {
    navigate(ROUTE)
}

fun NavGraphBuilder.gameResultRoute() {
    composable(route = ROUTE) {
        GameResultScreen()
    }
}

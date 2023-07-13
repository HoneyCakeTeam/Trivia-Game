package com.example.triviagame.ui.screens.game_result

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.triviagame.ui.LocalNavigationProvider

private const val ROUTE = "gameResult"

fun NavGraphBuilder.gameResultRoute() {
    composable(route = ROUTE) {
        GameScreen()
    }
}

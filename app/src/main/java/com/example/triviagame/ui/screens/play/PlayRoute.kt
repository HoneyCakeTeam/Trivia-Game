package com.example.triviagame.ui.screens.play

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "categories"

fun NavController.navigateToPlay() {
    navigate("${ROUTE}/${PlayArgs.NAME_ARG}/${PlayArgs.LEVEL}")
}

fun NavGraphBuilder.playRoute(navController: NavController) {
    composable(
        "$ROUTE/{${PlayArgs.NAME_ARG}}/{${PlayArgs.LEVEL}",
        arguments = listOf(
            navArgument(PlayArgs.NAME_ARG) {
                NavType.StringType
            },
            navArgument(PlayArgs.LEVEL) {
                NavType.StringType
            }
        )
    ) {
        PlayScreen(navController)
    }

}

class PlayArgs(savedStateHandle: SavedStateHandle) {
    val name: String = checkNotNull(savedStateHandle[NAME_ARG])
    val level: String = checkNotNull(savedStateHandle[LEVEL])

    companion object {
        const val NAME_ARG = "name"
        const val LEVEL = "level"
    }
}
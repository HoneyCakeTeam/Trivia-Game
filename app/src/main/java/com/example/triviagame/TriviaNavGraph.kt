package com.example.triviagame

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.triviagame.ui.screens.GameResult.gameResultRoute
import com.example.triviagame.ui.screens.answer_details.answerDetailsRoute
import com.example.triviagame.ui.screens.categories.categoriesRoute
import com.example.triviagame.ui.screens.play.playRoute

@Composable
fun TriviaNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Categories.rout) {
        categoriesRoute(navController)
        playRoute(navController)
        gameResultRoute(navController)
        answerDetailsRoute(navController)
    }
}
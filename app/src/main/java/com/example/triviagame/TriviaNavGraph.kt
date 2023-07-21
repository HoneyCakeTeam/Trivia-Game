package com.example.triviagame

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.screens.answer_details.answerDetailsRoute
import com.example.triviagame.ui.screens.categories.categoriesRoute
import com.example.triviagame.ui.screens.game_result.gameResultRoute
import com.example.triviagame.ui.screens.play.playRoute

@Composable
fun TriviaNavGraph() {
    val navController = LocalNavigationProvider.current

    NavHost(navController = navController, startDestination = Screen.Categories.rout) {
        categoriesRoute()
        playRoute()
        gameResultRoute()
        answerDetailsRoute()
    }
}
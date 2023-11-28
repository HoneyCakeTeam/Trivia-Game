package com.honey.triviagame

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.honey.triviagame.ui.LocalNavigationProvider
import com.honey.triviagame.ui.screens.answer_details.answerDetailsRoute
import com.honey.triviagame.ui.screens.categories.categoriesRoute
import com.honey.triviagame.ui.screens.game_result.gameResultRoute
import com.honey.triviagame.ui.screens.play.playRoute

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
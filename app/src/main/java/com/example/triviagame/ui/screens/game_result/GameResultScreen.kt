package com.example.triviagame.ui.screens.game_result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.Screen
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.screens.answer_details.AnswersUiState
import com.example.triviagame.ui.screens.game_result.composable.AnswerDetailsSection
import com.example.triviagame.ui.screens.game_result.composable.Footer
import com.example.triviagame.ui.screens.game_result.composable.ResultDetails
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel


@Composable
fun GameResultScreen() {
    val navController = LocalNavigationProvider.current
    val backStackEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("PlayScreen/{name}/{level}")
    }
    val viewModel: TriviaGameViewModel = hiltViewModel(backStackEntry)
    val state by viewModel.resultState.collectAsState()
    val answer = (state.correctAnswers / NUMBER_OF_QUESTIONS.toFloat()) * 100
    viewModel.savePoint(answer.toInt())

    GameContent(
        state = state,
        onClickBackToHome = {
            navController.popBackStack(Screen.Categories.rout, false)
        }, onClickBackToGame = {
            viewModel.getTriviaQuestions()
            navController.navigateUp()
        }, onClick = {
            navController.navigate(Screen.AnswerDetails.rout)
        })
}


@Composable
fun GameContent(
    state: AnswersUiState,
    modifier: Modifier = Modifier,
    onClickBackToHome: () -> Unit,
    onClickBackToGame: () -> Unit,
    onClick: () -> Unit,
) {
    val answer = (state.correctAnswers / NUMBER_OF_QUESTIONS.toFloat()) * 100
    val imageState = if (answer >= 50) R.drawable.winning_cup else R.drawable.game_over
    val textState = if (answer >= 50) "Greet Job !!" else "You Lose!"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ResultDetails(
            textState,
            state,
            imageState,
            onClick,
            textModifier = modifier.align(Alignment.CenterHorizontally))

        AnswerDetailsSection(
            state, modifier = modifier
                .padding(bottom = 8.dp)
                .align(Start))

        Spacer(modifier = Modifier.weight(1f))

        Footer(onClickBackToHome, onClickBackToGame)
    }
}




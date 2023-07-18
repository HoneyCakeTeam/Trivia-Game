package com.example.triviagame.ui.screens.play

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.screens.game_result.navigateToGameResult
import com.example.triviagame.ui.screens.play.composable.LottieAnimation
import com.example.triviagame.ui.screens.play.composable.NextButton
import com.example.triviagame.ui.screens.play.composable.PlayButtons
import com.example.triviagame.ui.screens.play.composable.PlayHeader
import com.example.triviagame.ui.screens.play.composable.QuestionCard
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS


@Composable
fun PlayScreen() {
    val navController = LocalNavigationProvider.current
    val backStackEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("PlayScreen/{name}/{level}")
    }
    val viewModel: PlayViewModel = hiltViewModel(backStackEntry)
    val state by viewModel.state.collectAsState()
    if (state.isLoading) {
        LottieAnimation()
    } else {
        PlayContent(
            state = state,
            onClickAnswer = viewModel::onClickAnswer,
            onClickNext = {
                if (state.currentQuestionIndex < NUMBER_OF_QUESTIONS - 1) {
                    viewModel.onClickNext()
                } else {
                    viewModel.addCurrentQuestionResult()
                    navController.navigateToGameResult()
                }
            },
            onClickBack = {
                navController.navigateUp()
            },
        )
    }

}

@Composable
private fun PlayContent(
    onClickAnswer: (String) -> Unit,
    state: PlayUiState,
    onClickNext: () -> Unit,
    onClickBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
            .padding(16.dp)
    ) {
        PlayHeader(
            onClickBack = onClickBack,
            onClickSkip = onClickNext
        )
        QuestionCard(
            state = state,
            onTimeOut = onClickNext
        )
        PlayButtons(
            answers = state.question.answers,
            selectedAnswer = state.question.selectedAnswer,
            onAnswerSelected = onClickAnswer,
            correctAnswer = state.question.correctAnswer,
            enabled = state.question.enabled
        )
        Spacer(modifier = Modifier.weight(1f))
        NextButton(
            buttonText = if (state.currentQuestionIndex < 9) "Next" else "Submit",
            enabled = !state.question.enabled,
            onClick = onClickNext
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen()
}


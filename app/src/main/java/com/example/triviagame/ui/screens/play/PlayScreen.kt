package com.example.triviagame.ui.screens.play

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.composable.GameButton
import com.example.triviagame.ui.screens.game_result.navigateToGameResult
import com.example.triviagame.ui.screens.play.composable.LottieAnimation
import com.example.triviagame.ui.screens.play.composable.TriviaAppBar
import com.example.triviagame.ui.screens.play.composable.QuestionCard
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS


@Composable
fun PlayScreen(
    viewModel: PlayViewModel = hiltViewModel(),
) {
    val navController = LocalNavigationProvider.current
    val state by viewModel.state.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        if (state.currentQuestionIndex < 0) {
            viewModel.refreshTriviaQuestions()
        }
    }
    if (state.isLoading) {
        LottieAnimation()
    } else {
        viewModel.getNextButtonText()
        PlayContent(
            state = state,
            onClickAnswer = viewModel::onClickAnswer,
            onClickNext = {
                if (state.currentQuestionIndex < NUMBER_OF_QUESTIONS - 1) {
                    viewModel.onClickNext()
                } else {
                    viewModel.saveCurrentQuestionResult()
                    viewModel.resetQuestionState()
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
        TriviaAppBar(
            onClickBack = onClickBack,
            onClickSkip = onClickNext,
            secondaryButtonText =stringResource(id = R.string.skip)
        )
        QuestionCard(
            state = state,
            onTimeOut = onClickNext
        )
        state.question.answers.forEach { answer ->
            GameButton(
                text = answer,
                onClick = onClickAnswer,
                correctAnswer = state.question.correctAnswer,
                selectedAnswer = state.question.selectedAnswer,
                enabled = state.question.enabled
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonItem(
            text = state.buttonText,
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


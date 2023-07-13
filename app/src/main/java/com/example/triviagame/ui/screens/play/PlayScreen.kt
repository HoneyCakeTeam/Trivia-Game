package com.example.triviagame.ui.screens.play

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.triviagame.R
import com.example.triviagame.Screen
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.composable.GameButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.Timer
import com.example.triviagame.ui.composable.spacing.padding_horizontal.SpacerHorizontal24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical32
import com.example.triviagame.ui.screens.game_result.navigateToGameResult
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.Black_87
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_EC
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel


@Composable
fun PlayScreen() {
    val navController = LocalNavigationProvider.current
    val backStackEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("PlayScreen/{name}/{level}")
    }
    val viewModel: TriviaGameViewModel = hiltViewModel(backStackEntry)
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
        QuestionCard(state = state)
        state.questions.getOrNull(state.currentQuestionIndex)?.let { question ->
            PlayButtons(
                answers = question.answers,
                selectedAnswer = question.selectedAnswer,
                onAnswerSelected = onClickAnswer,
                correctAnswer = question.correctAnswer,
                enabled = question.enabled
            )
            Spacer(modifier = Modifier.weight(1f))
            NextButton(
                buttonText = if (state.currentQuestionIndex < state.questions.size - 1) "Next" else "Submit",
                enabled = !question.enabled,
                onClick = onClickNext
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen()
}


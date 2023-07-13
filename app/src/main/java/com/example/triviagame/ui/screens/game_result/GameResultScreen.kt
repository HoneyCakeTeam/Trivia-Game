package com.example.triviagame.ui.screens.game_result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.Screen
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.screens.answer_details.AnswersUiState
import com.example.triviagame.ui.screens.game_result.composable.AnswerCard
import com.example.triviagame.ui.screens.game_result.composable.ReusableCard
import com.example.triviagame.ui.screens.game_result.composable.TextResult
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.Success
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.theme.Wrong
import com.example.triviagame.ui.theme.Yellow
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

    GameContent(
        state = state,
        onClickBackToHome = {
            navController.popBackStack(Screen.Categories.rout, false)
        }, onClickBackToGame = {
            navController.popBackStack(Screen.PlayScreen.rout, false)
        }, onClick = {
            navController.navigate(Screen.AnswerDetails.rout)
        })
}


@Composable
fun GameContent(
    state: AnswersUiState,
    onClickBackToHome: () -> Unit,
    onClickBackToGame: () -> Unit,
    onClick: () -> Unit,
) {
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
        TextResult(
            text = "Greet Job !!",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = Typography.titleLarge
        )
        AnswerCard(
            "You get " + "%.0f".format(
                ((state.correctAnswers / NUMBER_OF_QUESTIONS.toFloat()) * 100)
            ) + "%" + " Quiz Points", R.drawable.winning_cup, onClick = onClick
        )
        Text(
            text = "Answer Details", style = Typography.titleMedium, color = White_FF,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Start)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ReusableCard(
                    modifier = Modifier.weight(1f),
                    labelText = stringResource(R.string.correct),
                    questionCount = "${
                        state.correctAnswers
                    } Questions",
                    circleColor = Success
                )
                ReusableCard(
                    modifier = Modifier.weight(1f),
                    labelText = stringResource(R.string.completion),
                    questionCount = ("%.0f".format(
                        ((state.correctAnswers / NUMBER_OF_QUESTIONS.toFloat()) * 100)
                    ) + "%"),
                    circleColor = Secondary
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ReusableCard(
                    modifier = Modifier.weight(1f),
                    labelText = stringResource(R.string.skipped),
                    questionCount = "${
                        state.skippedAnswers
                    } Question",
                    circleColor = Yellow

                )
                ReusableCard(
                    modifier = Modifier.weight(1f),
                    labelText = stringResource(R.string.incorrect),
                    questionCount = "${
                        state.wrongAnswers
                    } Question",
                    circleColor = Wrong
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()
        ) {
            ButtonItem(
                text = stringResource(R.string.home_button), onClick = onClickBackToHome,
                buttonBackgroundColor = CardBackgroundColor,
                textColor = White_FF, modifier = Modifier.weight(1f)
            )
            ButtonItem(
                text = stringResource(R.string.play_again_button), onClick = onClickBackToGame,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
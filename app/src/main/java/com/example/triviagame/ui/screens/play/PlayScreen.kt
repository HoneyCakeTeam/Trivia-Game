package com.example.triviagame.ui.screens.play

import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.triviagame.R
import com.example.triviagame.ui.composable.GameButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.OutlinePlayButton
import com.example.triviagame.ui.composable.Timer
import com.example.triviagame.ui.composable.spacing.padding_horizontal.SpacerHorizontal24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical32
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.Black_87
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_EC
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel
import kotlinx.coroutines.delay


@Composable
fun PlayScreen(
    navController: NavController,
) {
    val backStackEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("PlayScreen/{name}/{level}")
    }
    val viewModel: TriviaGameViewModel = hiltViewModel(backStackEntry)
    val state by viewModel.state.collectAsState()
    PlayContent(
        state = state,
        onClickAnswer = viewModel::onClickAnswer,
        onClickNext = viewModel::onClickNext
    )
}

@Composable
private fun PlayContent(
    onClickAnswer: (String) -> Unit,
    state: PlayUiState,
    onClickNext: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
            .padding(16.dp)
    ) {
        Header()
        SpacerHorizontal24()
        Box {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(CardBackgroundColor)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SpacerVertical32()
                    var value by remember {
                        mutableFloatStateOf(1f)
                    }
                    var currentTime by remember {
                        mutableLongStateOf(state.timer)
                    }
                    LaunchedEffect(key1 = currentTime) {
                        if (currentTime > 0) {
                            delay(100L)
                            currentTime -= 100L
                            value = currentTime / state.timer.toFloat()
                        } else {
                            state.timer = 0
                            onClickNext()
                        }
                    }
                    Timer(
                        currentTime = currentTime,
                        activeBarColor = Secondary,
                        value = value,
                        modifier = Modifier.size(64.dp)
                    )
                    SpacerVertical16()
                    state.questions.getOrNull(state.currentQuestionIndex)?.question?.let {
                        Text(
                            text = it,
                            color = White_EC,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                        )
                    }
                    SpacerVertical16()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    }
                }
            }
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .width(186.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Secondary)
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.question),
                        color = Black_87,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "${state.currentQuestionIndex + 1}/${state.numberOfQuestions}",
                        color = Black_87,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        SpacerVertical32()
        state.questions.getOrNull(state.currentQuestionIndex)?.let {
            PlayButtons(
                answers = it.answers,
                selectedAnswer = it.selectedAnswer,
                onAnswerSelected = onClickAnswer
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (state.currentQuestionIndex < state.questions.size - 1) {
            NextButton(
                buttonText = "Next",
                onClick = onClickNext
            )
        } else {
            NextButton(buttonText = "Submit") {
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageButton(R.drawable.arrow_left, backgroundColor = CardBackgroundColor) {}
        Text(
            text = stringResource(id = R.string.skip),
            color = White_FF,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Composable
private fun PlayButtons(
    answers: List<String>,
    selectedAnswer: String,
    onAnswerSelected: (String) -> Unit,
) {
    answers.forEachIndexed { _, answer ->
        val isSelected = answer == selectedAnswer
        if (isSelected) {
            OutlinePlayButton(
                text = answer,
                onClick = { onAnswerSelected(answer) }
            )
        } else {
            GameButton(
                text = answer,
                onClick = { onAnswerSelected(answer) }
            )
        }
        SpacerVertical16()
    }
}

@Composable
private fun NextButton(buttonText: String, onClick: () -> Unit) {
    GameButton(
        text = buttonText,
        textColor = Black_60,
        buttonColor = Secondary,
        onClick = onClick
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen(navController = NavHostController(LocalContext.current))
}


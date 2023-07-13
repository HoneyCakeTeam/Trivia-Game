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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.triviagame.R
import com.example.triviagame.ui.composable.GameButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.OutlinePlayButton
import com.example.triviagame.ui.composable.Timer
import com.example.triviagame.ui.composable.spacing.padding_horizontal.SpacerHorizontal24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical32
import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.Black_87
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_EC
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel


@Composable
fun PlayScreen(
    navController: NavController,
    viewModel: TriviaGameViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    PlayContent(state = state)
}

@Composable
private fun PlayContent(state: PlayUiState) {
    var state by remember { mutableStateOf(state) }
    val currentQuestion = state.questions[state.currentQuestionIndex]
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
                    Timer(
                        totalTime = currentQuestion.timer,
                        activeBarColor = Secondary,
                        modifier = Modifier.size(64.dp)
                    )
                    SpacerVertical16()
                    Text(
                        text = currentQuestion.question,
                        color = White_EC,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
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
                        text = "${currentQuestion.questionNumber}/${state.numberOfQuestions}",
                        color = Black_87,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
        SpacerVertical32()
        PlayButtons(
            answers = state.questions[state.currentQuestionIndex].answers,
            selectedAnswer = state.questions[state.currentQuestionIndex].selectedAnswer,
        ) { answer ->
            state = state.copy(
                questions = state.questions.mapIndexed { index, question ->
                    if (index == state.currentQuestionIndex) {
                        question.copy(selectedAnswer = answer)
                    } else {
                        question
                    }
                }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (state.currentQuestionIndex < state.questions.size - 1) {
            NextButton(buttonText = "Next") {
                state = state.copy(currentQuestionIndex = state.currentQuestionIndex + 1)
            }
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
    answers: List<AnswerUiState>,
    selectedAnswer: String,
    onAnswerSelected: (String) -> Unit,
) {
    answers.forEachIndexed { _, answer ->
        val isSelected = answer.answer == selectedAnswer
        if (isSelected) {
            OutlinePlayButton(
                text = answer.answer,
                onClick = { onAnswerSelected(answer.answer) }
            )
        } else {
            GameButton(
                text = answer.answer,
                onClick = { onAnswerSelected(answer.answer) }
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

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
/*fun PreviewPlayScreen() {
    val sampleState = PlayUiState(
        questions = listOf(
            QuestionUiState(
                question = "Sample Question 1",
                answers = listOf(
                    AnswerUiState(
                        id = 1,
                        state = QuestionState.NOT_ANSWERED,
                        question = "Sample Question 1",
                        answer = "Sample Answer 1"
                    ),
                    AnswerUiState(
                        id = 2,
                        state = QuestionState.NOT_ANSWERED,
                        question = "Sample Question 1",
                        answer = "Sample Answer 2"
                    ),
                    AnswerUiState(
                        id = 3,
                        state = QuestionState.NOT_ANSWERED,
                        question = "Sample Question 1",
                        answer = "Sample Answer 3"
                    ),
                    AnswerUiState(
                        id = 4,
                        state = QuestionState.NOT_ANSWERED,
                        question = "Sample Question 1",
                        answer = "Sample Answer 4"
                    )
                ),
                correctAnswer = "Sample Answer 1",
                isAnswered = false,
                isCorrect = false,
                questionNumber = 1
            ),
            QuestionUiState(
                question = " Question 2",
                answers = listOf(
                    AnswerUiState(
                        id = 1,
                        state = QuestionState.NOT_ANSWERED,
                        question = " Question 2",
                        answer = " Answer 1"
                    ),
                    AnswerUiState(
                        id = 2,
                        state = QuestionState.NOT_ANSWERED,
                        question = " Question 2",
                        answer = " Answer 2"
                    ),
                    AnswerUiState(
                        id = 3,
                        state = QuestionState.NOT_ANSWERED,
                        question = " Question 2",
                        answer = " Answer 3"
                    ),
                    AnswerUiState(
                        id = 4,
                        state = QuestionState.NOT_ANSWERED,
                        question = " Question 2",
                        answer = " Answer 4"
                    )
                ),
                correctAnswer = " Answer 2",
                isAnswered = false,
                isCorrect = false,
                questionNumber = 2
            ),
        ),
        numberOfQuestions = 10,
        currentQuestionIndex = 0,
        userScore = 0,
    )
    PlayScreen(navController = NavHostController(LocalContext.current))
}*/

@Preview
@Composable
fun PreviewPlay2Screen() {
    PlayScreen(navController = NavController(LocalContext.current))
}


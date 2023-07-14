package com.example.triviagame.ui.screens.answer_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.Screen
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.composable.AppBarWithIconBack
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.composable.TextLabel
import com.example.triviagame.ui.screens.answer_details.composable.AnswerChart
import com.example.triviagame.ui.screens.answer_details.composable.QuestionItem
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel

/**
 * Created by Aziza Helmy on 7/4/2023.
 */

@Composable
fun AnswerDetailsScreen() {
    var animationPlayed by remember { mutableStateOf(false) }
    val navController = LocalNavigationProvider.current

    val backStackEntry = remember(navController.currentBackStackEntry) {
        navController.getBackStackEntry("PlayScreen/{name}/{level}")
    }
    val viewModel: TriviaGameViewModel = hiltViewModel(backStackEntry)
    val state by viewModel.resultState.collectAsState()

    AnswerDetailsContent(
        animationPlayed = animationPlayed,
        onClickBack = {
            navController.popBackStack(Screen.Categories.rout, false)
        },
        answersUiState = state,
        onBack = {
            navController.navigateUp()
        }
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
}


@Composable
fun AnswerDetailsContent(
    animationPlayed: Boolean,
    onClickBack: () -> Unit,
    answersUiState: AnswersUiState,
    onBack: () -> Unit
) {
    Box {
        AppBarWithIconBack(
            stringResource(R.string.review_answer),
            modifier = Modifier
                .zIndex(2f),
            onBack = onBack
        )
        Box(
            modifier = Modifier
                .background(color = Primary)
                .padding(vertical = 90.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .verticalScroll(rememberScrollState(), reverseScrolling = false)
            ) {
                AnswerChart(
                    quizType = "Science",
                    correctAnswerPrecedent = (
                            (answersUiState.correctAnswers / NUMBER_OF_QUESTIONS.toFloat())
                                    * 100).toInt(),
                    inCorrectAnswerPrecedent = 100 - (
                            (answersUiState.correctAnswers / NUMBER_OF_QUESTIONS.toFloat())
                                    * 100).toInt(),
                    animationPlayed = animationPlayed,
                    answersUiState = answersUiState
                )
                TextLabel(stringResource(R.string.your_answers))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = CardBackgroundColor, shape = RoundedShape.large)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        answersUiState.questions.forEachIndexed() { index, item ->
                            QuestionItem(item, index + 1)
                        }
                    }
                }
            }
        }
        ButtonItem(
            text = stringResource(R.string.done),
            onClick = onClickBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        )

    }

}
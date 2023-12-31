package com.honey.triviagame.ui.screens.answer_details

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
import com.honey.triviagame.R
import com.honey.triviagame.Screen
import com.honey.triviagame.ui.LocalNavigationProvider
import com.honey.triviagame.ui.composable.AppBarWithIconBack
import com.honey.triviagame.ui.composable.ButtonItem
import com.honey.triviagame.ui.composable.TextLabel
import com.honey.triviagame.ui.screens.answer_details.composable.AnswerChart
import com.honey.triviagame.ui.screens.answer_details.composable.QuestionItem
import com.honey.triviagame.ui.theme.CardBackgroundColor
import com.honey.triviagame.ui.theme.Primary
import com.honey.triviagame.ui.theme.RoundedShape
import com.honey.triviagame.ui.util.toTitleCase

/**
 * Created by Aziza Helmy on 7/4/2023.
 */

@Composable
fun AnswerDetailsScreen(
    viewModel: AnswerDetailsViewModel = hiltViewModel(),
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val navController = LocalNavigationProvider.current
    val state by viewModel.state.collectAsState()

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
    onBack: () -> Unit,
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
                    quizType = answersUiState.questions[0].type.toTitleCase(),
                    correctAnswerPrecedent = answersUiState.correctAnswersPercentage,
                    inCorrectAnswerPrecedent = answersUiState.inCorrectAnswersPercentage,
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
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.triviagame.R
import com.example.triviagame.ui.composable.AppBarWithIconBack
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.composable.TextLabel
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical8
import com.example.triviagame.ui.screens.answer_details.composable.AnswerChart
import com.example.triviagame.ui.screens.answer_details.composable.QuestionItem
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.util.QuestionState

/**
 * Created by Aziza Helmy on 7/4/2023.
 */


@Composable
fun AnswerDetailsScreen() {

}


@Preview(showSystemUi = true)
@Composable
fun AnswerDetailsContent() {
    val question = listOf(
        AnswerUiState(
            id = 0,
            question = "What is the capital of Egypt?",
            state = QuestionState.Correct,
            answer = "Cairo",
        ),
        AnswerUiState(
            id = 1,
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            id = 3,
            question = "What is the name of the tallest grass on earth?",
            state = QuestionState.Wrong,
            answer = "Bamboo",
        ),
        AnswerUiState(
            id = 4,
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            id = 5,
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            id = 6,
            question = "What is the study of mushrooms called?",
            state = QuestionState.SKIPPED,
            answer = "Mycology",
        ),
    )
    Box {
        AppBarWithIconBack(
            stringResource(R.string.review_answer),
            modifier = Modifier.zIndex(2f),
            onBack = {})
        Box(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.background),
                    contentScale = ContentScale.Crop
                )
                .padding(top = 100.dp, bottom = 150.dp)
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
                    correctAnswerPrecedent = 20,
                    inCorrectAnswerPrecedent = 80
                )
                SpacerVertical16()
                TextLabel(stringResource(R.string.your_answers))
                SpacerVertical8()
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = CardBackgroundColor, shape = RoundedShape.large)
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        question.forEach { item ->
                            QuestionItem(item)
                        }
                    }
                }

            }

        }
        ButtonItem(
            text = stringResource(R.string.done),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 68.dp)
                .align(Alignment.BottomCenter)
        )

    }

}
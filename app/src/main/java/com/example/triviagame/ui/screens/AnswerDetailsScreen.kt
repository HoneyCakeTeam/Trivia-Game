package com.example.triviagame.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.answer_details.AnswerChart
import com.example.triviagame.ui.composable.AppBar
import com.example.triviagame.ui.composable.answer_details.QuestionItem
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical8
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.Shapes
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.theme.Yellow
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
            question = "What is the capital of Egypt?",
            state = QuestionState.Correct,
            answer = "Cairo",
        ),
        AnswerUiState(
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            question = "What is the name of the tallest grass on earth?",
            state = QuestionState.Wrong,
            answer = "Bamboo",
        ),
        AnswerUiState(
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            question = "What is the study of mushrooms called?",
            state = QuestionState.Wrong,
            answer = "Mycology",
        ),
        AnswerUiState(
            question = "What is the study of mushrooms called?",
            state = QuestionState.SKIPPED,
            answer = "Mycology",
        ),
    )
    Box(modifier = Modifier.background(color = Primary)) {
        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            Column {

                SpacerVertical24()
                AppBar(stringResource(R.string.review_answer))
                LazyColumn(modifier = Modifier.wrapContentHeight()) {

                    item {
                        SpacerVertical24()
                        AnswerChart()
                        SpacerVertical16()
                        Text(
                            text = "Your Answers",
                            style = Typography.titleMedium,
                            color = White_FF,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            textAlign = TextAlign.Start
                        )
                        SpacerVertical8()
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 16.dp)
                                .background(color = Card, shape = Shapes.large)
                        ) {

                            Column(modifier = Modifier.padding(16.dp)) {
                                question.forEach { item ->
                                    QuestionItem(item)
                                }
                            }
                        }
                        SpacerVertical24()
                    }
                }
            }
        }

    }

}

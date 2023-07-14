package com.example.triviagame.ui.screens.game_result.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.screens.answer_details.AnswersUiState
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.Success
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.theme.Wrong
import com.example.triviagame.ui.theme.Yellow
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS

/**
 * Created by Aziza Helmy on 7/14/2023.
 */

@Composable
fun AnswerDetailsSection(state: AnswersUiState, modifier: Modifier) {
    Text(
        text = "Answer Details", style = Typography.titleMedium, color = White_FF,
        modifier = modifier
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
}

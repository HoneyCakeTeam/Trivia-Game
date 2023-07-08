package com.example.triviagame.ui.screens.answer_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical24
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF


@Composable
fun AnswerChart(
    quizType:String,
    correctAnswerPrecedent:Int,
    inCorrectAnswerPrecedent:Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentHeight()
            .background(color = CardBackgroundColor, shape = RoundedShape.large)
    ) {
        Text(
            text = stringResource(R.string.quiz_type),
            style = Typography.bodyMedium,
            color = White_FF,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Start
        )
        Text(
            text = quizType,
            style = Typography.titleLarge,
            color = White_FF,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 24.dp),
            textAlign = TextAlign.Start
        )

        Box(modifier = Modifier.size(200.dp).fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            CircleWithText(text = stringResource(R.string.correct_small_case), color = Color.White, percentage = "%$correctAnswerPrecedent")
            CircleWithText(text = stringResource(R.string.incorrect_small_case), color = Primary, percentage = "%$inCorrectAnswerPrecedent")
        }
        SpacerVertical24()
    }
}
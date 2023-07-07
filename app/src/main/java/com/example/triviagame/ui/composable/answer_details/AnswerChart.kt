package com.example.triviagame.ui.composable.answer_details

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical24
import com.example.triviagame.ui.screens.CircleWithText
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.Shapes
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@Composable
fun AnswerChart(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
            .background(color = Card, shape = Shapes.large)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = "Quiz Type",
                style = Typography.bodyMedium,
                color = White_FF,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp),
                textAlign = TextAlign.Start
            )
            Text(
                text = "Science",
                style = Typography.titleLarge,
                color = White_FF,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 24.dp),
                textAlign = TextAlign.Start
            )

            Box(modifier = Modifier
                .size(200.dp)
                .fillMaxWidth(), content = {})
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                CircleWithText(text = "Correct", color = Color.White, percentage = "%80")
                CircleWithText(text = "Correct", color = Primary, percentage = "%20")
            }
            SpacerVertical24()

        }
    }
}
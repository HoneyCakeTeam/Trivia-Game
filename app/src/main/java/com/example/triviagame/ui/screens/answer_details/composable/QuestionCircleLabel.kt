package com.example.triviagame.ui.screens.answer_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@Preview
@Composable
fun QuestionCircleLabel(
    questionNumber: Int = 0,
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(shape = RoundedShape.medium, color = Primary),
    ) {
        Text(
            text = "Q$questionNumber",
            style = Typography.bodySmall,
            color = White_FF,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize()
        )

    }
}
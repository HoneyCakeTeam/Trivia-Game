package com.example.triviagame.ui.screens.answer_details.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF
import com.example.triviagame.ui.theme.Yellow


@Preview
@Composable
fun CircleWithText(
    color: Color = Color.Red,
    modifier: Modifier = Modifier,
    text: String = "",
    percentage: String = "",
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(color = color, shape = RoundedShape.extraLarge)
        )
        Text(
            text = text,
            style = Typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp),
            color = White_FF
        )
        Text(
            text = percentage,
            style = Typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp),
            color = Yellow
        )
    }
}
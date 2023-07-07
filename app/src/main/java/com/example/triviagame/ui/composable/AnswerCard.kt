package com.example.triviagame.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Error
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.Shape
import com.example.triviagame.ui.theme.Success
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_EC

@Composable
fun AnswerCard(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    isSuccess: Boolean
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .border(
                width = 2.dp,
                color = if (isSelected) Secondary else Card,
                shape = Shape.medium
            )
            .background(
                color = if (isSelected) {
                    if (isSuccess) {
                        Success
                    } else {
                        Error
                    }
                } else Card,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onChecked(!isSelected)
            }
    ) {
        Text(
            text = text,
            style = Typography.bodyLarge,
            color = if (isSelected) White_EC else White_EC
        )
    }
}
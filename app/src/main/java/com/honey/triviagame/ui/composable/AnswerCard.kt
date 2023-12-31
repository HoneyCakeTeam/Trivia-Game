package com.honey.triviagame.ui.composable

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
import androidx.compose.ui.unit.dp
import com.honey.triviagame.ui.theme.CardBackgroundColor
import com.honey.triviagame.ui.theme.Wrong
import com.honey.triviagame.ui.theme.RoundedShape
import com.honey.triviagame.ui.theme.Secondary
import com.honey.triviagame.ui.theme.Success
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.theme.White_EC

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
                color = if (isSelected) Secondary else CardBackgroundColor,
                shape = RoundedShape.medium
            )
            .background(
                color = if (isSelected) {
                    if (isSuccess) {
                        Success
                    } else {
                        Wrong
                    }
                } else CardBackgroundColor,
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
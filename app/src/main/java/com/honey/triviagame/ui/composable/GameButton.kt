package com.honey.triviagame.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.honey.triviagame.ui.theme.CardBackgroundColor
import com.honey.triviagame.ui.theme.Secondary
import com.honey.triviagame.ui.theme.Success
import com.honey.triviagame.ui.theme.White_EC
import com.honey.triviagame.ui.theme.Wrong

@Composable
fun GameButton(
    text: String,
    textColor: Color = White_EC,
    onClick: (String) -> Unit,
    selectedAnswer: String = "",
    correctAnswer: String,
    enabled:Boolean
) {
    val selected = (text == selectedAnswer)
    val isRightAnswer = correctAnswer == text

    val buttonContainerColor by animateColorAsState(
        when {
            selected && isRightAnswer -> {
                Success
            }
            selected && !isRightAnswer -> {
                Wrong
            }
            selectedAnswer != "" && isRightAnswer -> {
                Success
            }
            else -> {
                CardBackgroundColor
            }
        },
        tween(300)
    )
    val buttonBorderColor by animateColorAsState(
        if (selected) Secondary else Color.Transparent,
        tween(300)
    )

    Button(
        onClick = { onClick(text) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .defaultMinSize(minHeight = 54.dp)
            .border(1.dp, buttonBorderColor, shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(buttonContainerColor,disabledContainerColor = buttonContainerColor),
        enabled = enabled
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = text, style = MaterialTheme.typography.bodyLarge, color = textColor
        )
    }
}
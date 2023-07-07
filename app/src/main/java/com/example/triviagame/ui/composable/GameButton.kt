package com.example.triviagame.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.White_EC

@Composable
fun GameButton(
    text: String,
    textColor: Color = White_EC,
    buttonColor: Color = Card,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Text(text = text, style = MaterialTheme.typography.bodyLarge, color = textColor)
    }
}
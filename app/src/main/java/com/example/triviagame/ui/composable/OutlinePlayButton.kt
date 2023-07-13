package com.example.triviagame.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun OutlinePlayButton(
    text: String,
    buttonColor: Color = Color(0xFF6F2F7B),
    onClick: (String) -> Unit,
) {
    Button(
        onClick = {onClick(text)},
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .border(width = 1.dp, color = Color(0xFFC8C4F0), shape = RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(buttonColor)
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = text, fontSize = 16.sp
        )
    }
}

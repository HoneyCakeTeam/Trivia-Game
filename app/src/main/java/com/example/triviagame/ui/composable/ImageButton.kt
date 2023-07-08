package com.example.triviagame.ui.composable


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImageButton(
    painter: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    iconTint: Color = Color.Unspecified,
    text: String = "",
    color: Color = Color.White,
    textSize: Int = 16,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(color = backgroundColor)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(painter),
            contentDescription = "$text button",
            tint = iconTint
        )
        if (text.isNotEmpty()) {
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                fontSize = textSize.sp,
                color = color
            )
        }
    }
}
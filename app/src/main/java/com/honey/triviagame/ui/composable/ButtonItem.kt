package com.honey.triviagame.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.honey.triviagame.ui.theme.Black_60
import com.honey.triviagame.ui.theme.RoundedShape
import com.honey.triviagame.ui.theme.Secondary
import com.honey.triviagame.ui.theme.Typography

@Composable
fun ButtonItem(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonBackgroundColor: Color = Secondary,
    textColor: Color = Black_60,
    enabled: Boolean = true,
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            buttonBackgroundColor
        ),
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        shape = RoundedShape.medium
    ) {
        Text(
            text = text,
            style = Typography.bodyMedium,
            color = textColor
        )
    }
}
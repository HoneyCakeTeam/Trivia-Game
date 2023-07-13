package com.example.triviagame.ui.screens.play.composable

import androidx.compose.runtime.Composable
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.theme.Black_60

@Composable
 fun NextButton(
    buttonText: String, onClick: () -> Unit,
    enabled: Boolean,
) {
    ButtonItem(
        text = buttonText,
        textColor = Black_60,
        onClick = onClick,
        enabled = enabled
    )
}
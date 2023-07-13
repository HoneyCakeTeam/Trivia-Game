package com.example.triviagame.ui.screens.play.composable

import androidx.compose.runtime.Composable
import com.example.triviagame.ui.composable.GameButton

@Composable
fun PlayButtons(
    answers: List<String>,
    selectedAnswer: String,
    correctAnswer: String,
    onAnswerSelected: (String) -> Unit,
    enabled: Boolean,
) {

    answers.forEach { answer ->
        GameButton(
            text = answer,
            onClick = onAnswerSelected,
            correctAnswer = correctAnswer,
            selectedAnswer = selectedAnswer,
            enabled = enabled
        )
    }
}

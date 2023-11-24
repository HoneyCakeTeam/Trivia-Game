package com.honey.triviagame.ui.screens.game_result.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honey.triviagame.ui.screens.game_result.GameResultUiState
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.util.NUMBER_OF_QUESTIONS

/**
 * Created by Aziza Helmy on 7/14/2023.
 */

@Composable
 fun ResultDetails(
    textState: String,
    state: GameResultUiState,
    imageState: Int,
    onClick: () -> Unit,
    textModifier: Modifier = Modifier
) {
    TextResult(
        text = textState,
        modifier = textModifier,
        style = Typography.titleLarge
    )
    AnswerCard(
        "You get " + "%.0f".format(
            ((state.correctAnswersCount / NUMBER_OF_QUESTIONS.toFloat()) * 100)
        ) + "%" + " Quiz Points",
        imageState,
        onClick = onClick
    )

}


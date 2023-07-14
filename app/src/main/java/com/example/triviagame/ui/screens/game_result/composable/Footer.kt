package com.example.triviagame.ui.screens.game_result.composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.White_FF

/**
 * Created by Aziza Helmy on 7/14/2023.
 */

@Composable
fun Footer(onClickBackToHome: () -> Unit, onClickBackToGame: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonItem(
            text = stringResource(R.string.home_button), onClick = onClickBackToHome,
            buttonBackgroundColor = CardBackgroundColor,
            textColor = White_FF, modifier = Modifier.weight(1f)
        )
        ButtonItem(
            text = stringResource(R.string.play_again_button), onClick = onClickBackToGame,
            modifier = Modifier.weight(1f)
        )
    }
}
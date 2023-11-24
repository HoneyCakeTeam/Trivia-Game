package com.honey.triviagame.ui.screens.play.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.honey.triviagame.ui.composable.ButtonBack
import com.honey.triviagame.ui.theme.White_FF

@Composable
fun TriviaAppBar(
    modifier: Modifier = Modifier,
    secondaryButtonText:String,
    onClickBack: () -> Unit,
    onClickSkip: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ButtonBack(onBack = onClickBack)
        Text(
            modifier = modifier.clickable { onClickSkip() },
            text =secondaryButtonText,
            color = White_FF,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

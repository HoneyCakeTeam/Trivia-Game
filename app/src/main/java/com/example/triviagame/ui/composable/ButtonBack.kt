package com.example.triviagame.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.RoundedShape


@Preview
@Composable
fun ButtonBack(modifier: Modifier = Modifier, onBack: () -> Unit = {}) {
    IconButton(
        onClick = onBack,
        modifier = modifier
            .background(shape = RoundedShape.medium, color = CardBackgroundColor)
            .size(32.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = null, tint = Color.White
        )
    }
}






package com.example.triviagame.ui.screens.play.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.triviagame.R
import com.example.triviagame.ui.theme.Primary

@Composable
fun LottieAnimation() {
    val animationSpeed by remember { mutableFloatStateOf(1f) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    val lottieAnimation by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        speed = animationSpeed,
        restartOnPlay = false
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        com.airbnb.lottie.compose.LottieAnimation(
            composition,
            lottieAnimation,
            modifier = Modifier.size(200.dp)
        )
    }
}
package com.example.triviagame.ui.composable.answer_details_composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.PrimaryChip
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16


@Composable
fun CardWinScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = com.example.triviagame.ui.theme.Card),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            ImageResult(painter = painterResource(id = R.drawable.winning_cup))
            SpacerVertical16()
            SpacerVertical16()
            Text("You get +80 Quiz Points")
            SpacerVertical16()
//            PrimaryButton(text = "Primary", modifier = Modifier, width = 200)
            PrimaryChip(text = "Primary", selected = true, onChipState = {})
            SpacerVertical16()
        }

    }

}

@Composable
fun ImageResult(
    painter: Painter,
    size: Int = 200,
) {
    Image(
        painter = painter,
        contentDescription = "Profile picture",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .size(size.dp)
    )
}

@Preview
@Composable
fun PreviewCardWinScreen() {
    CardWinScreen()

}
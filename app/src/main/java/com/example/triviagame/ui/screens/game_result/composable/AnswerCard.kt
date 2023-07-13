package com.example.triviagame.ui.screens.game_result.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.ButtonItem
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF


@Composable
fun AnswerCard(text: String, image: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        shape = RoundedShape.large
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = CardBackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            ImageResult(painter = painterResource(image))
            TextResult(text = text)
            ButtonCheckAnswer(text = stringResource(R.string.check_your_answer), onClick = onClick)
        }
    }
}

@Composable
fun TextResult(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.bodyMedium,
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        color = White_FF
    )
}

@Composable
fun ButtonCheckAnswer(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ButtonItem(
        text = text, onClick = onClick, modifier = modifier
            .width(200.dp)
            .padding(bottom = 16.dp), buttonBackgroundColor = Primary, textColor = White_FF
    )
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
            .clip(RoundedShape.large)
            .size(size.dp)
    )
}
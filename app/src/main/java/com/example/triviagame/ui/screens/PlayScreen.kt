package com.example.triviagame.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.GameButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.spacing.padding_horizontal.SpacerHorizontal24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical32
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.Black_87
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_EC
import com.example.triviagame.ui.theme.White_FF


@Composable
fun PlayScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(BackGround)
            .padding(16.dp),
    ) {

        Header()

        SpacerHorizontal24()

        PlayContent(
            percent = "30",
            joke = "What microbes are used to \n break down plant matter for \n composting?",
            questionNumber = "7/10"
        )

        SpacerVertical32()

        PlayButtons(
            "Bacteria", "Mold",
            "Fungus", "Algae"
        )

        Spacer(modifier = Modifier.weight(1f))

        nextButton(buttonText = "Next")

    }

}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageButton(R.drawable.arrow_left, backgroundColor = Card) {}
        Text(
            text = stringResource(id = R.string.skip),
            color = White_FF,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun PlayContent(
    percent: String,
    joke: String,
    questionNumber: String
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 26.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .background(Card)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    SpacerVertical32()

                    Text(
                        text = percent,
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                color = Card, shape = CircleShape
                            )
                            .border(
                                width = 6.dp, color = Secondary, shape = CircleShape
                            )
                            .padding(22.dp),
                        color = White_FF,
                        style = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.Center
                    )
                    SpacerVertical16()

                    Text(
                        text = joke,
                        color = White_EC,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                    )
                    SpacerVertical16()

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ImageButton(
                            painter = R.drawable.arrow_square_left, iconTint = Secondary
                        ) {}
                        ImageButton(
                            painter = R.drawable.arrow_square_right, iconTint = Secondary
                        ) {}
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(186.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .background(Secondary)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.question),
                    color = Black_87,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = questionNumber,
                    color = Black_87,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }

    }

}

@Composable
private fun PlayButtons(
    firstQuestion: String,
    secondQuestion: String,
    thirdQuestion: String,
    fourthQuestion: String
) {
    GameButton(text = firstQuestion) {}
    SpacerVertical16()
    GameButton(text = secondQuestion) {}
    SpacerVertical16()
    GameButton(text = thirdQuestion) {}
    SpacerVertical16()
    GameButton(text = fourthQuestion) {}
    SpacerVertical16()
}

@Composable
private fun nextButton(buttonText: String) {
    GameButton(
        text = buttonText, textColor = Black_60, buttonColor = Secondary
    ) {}
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen()
}
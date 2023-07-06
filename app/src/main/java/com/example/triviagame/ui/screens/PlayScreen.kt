package com.example.triviagame.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.ActionButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.PlayButton
import com.example.triviagame.ui.theme.BackGround
import com.example.triviagame.ui.theme.Card
import com.example.triviagame.ui.theme.Secondary
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

        Spacer(Modifier.height(24.dp))

        PlayContent(
            percent = "30",
            joke = "What microbes are used to \n break down plant matter for \n composting?",
            questionNumber = "7/10"
        )

        Spacer(Modifier.height(32.dp))

        PlayButtons(
            "Bacteria", "Mold",
            "Fungus", "Algae"
        )

        Spacer(modifier = Modifier.height(24.dp))

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
        Text(text = stringResource(id = R.string.skip), color = White_FF)
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

                    Spacer(modifier = Modifier.height(32.dp))

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
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = joke,
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(16.dp))

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
                Text(text = stringResource(R.string.question), fontSize = 16.sp)
                Text(text = questionNumber, fontSize = 16.sp)
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
    PlayButton(text = firstQuestion, onClick = {})
    Spacer(Modifier.height(16.dp))
    PlayButton(text = secondQuestion, onClick = {})
    Spacer(Modifier.height(16.dp))
    PlayButton(text = thirdQuestion, onClick = {})
    Spacer(Modifier.height(16.dp))
    PlayButton(text = fourthQuestion, onClick = {})
}

@Composable
private fun nextButton(buttonText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
    ) {
        ActionButton(
            text = buttonText, onClick = {})
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen()
}
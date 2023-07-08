package com.example.triviagame.ui.screens.game_result

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.triviagame.R
import com.example.triviagame.Screen
import com.example.triviagame.ui.composable.answer_details_composable.AlignText
import com.example.triviagame.ui.composable.answer_details_composable.AnswerCard
import com.example.triviagame.ui.composable.answer_details_composable.CustomButton
import com.example.triviagame.ui.composable.answer_details_composable.ReusableCard
import com.example.triviagame.ui.composable.answer_details_composable.TextResult
import com.example.triviagame.ui.composable.spacing.padding_horizontal.SpacerHorizontal12
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical12
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical24
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical32
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF


@Composable
fun GameScreen(navController: NavController) {
    GameContent(onClickBackToHome = {
        navController.popBackStack(Screen.Categories.rout, false)
    }, onClickBackToGame = {
        navController.popBackStack(Screen.PlayScreen.rout, false)
    }, onClick = {
        navController.navigate(Screen.AnswerDetails.rout)
    })
}


@Composable
fun GameContent(
    onClickBackToHome: () -> Unit,
    onClickBackToGame: () -> Unit,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SpacerVertical16()
        TextResult(
            text = "Greet Job !!",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = Typography.titleLarge
        )
        SpacerVertical32()
        AnswerCard("You get +80 Quiz Points", R.drawable.winning_cup, onClick = onClick)
        SpacerVertical24()
        AlignText("Answer Details", TextAlign.Start, modifier = Modifier)
        SpacerVertical16()
        Row {
            Box(modifier = Modifier.weight(1f)) {
                ReusableCard(
                    modifier = Modifier,
                    labelText = stringResource(R.string.correct),
                    questionCount = "7 Questions",
                    icon = R.drawable.dot_blue
                )

            }
            SpacerHorizontal12()

            Box(modifier = Modifier.weight(1f)) {
                ReusableCard(
                    modifier = Modifier,
                    labelText = stringResource(R.string.completion),
                    questionCount = "7 Questions",
                    icon = R.drawable.dot_mint
                )
            }

        }
        SpacerVertical12()
        Row {
            Box(modifier = Modifier.weight(1f)) {
                ReusableCard(
                    modifier = Modifier,
                    labelText = stringResource(R.string.skipped),
                    questionCount = "7 Questions",
                    icon = R.drawable.dot_yellow

                )
            }
            SpacerHorizontal12()
            Box(modifier = Modifier.weight(1f)) {
                ReusableCard(
                    modifier = Modifier,
                    labelText = stringResource(R.string.incorrect),
                    questionCount = "7 Questions",
                    icon = R.drawable.dot_baby_blue
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Box(modifier = Modifier.weight(1f)) {
                CustomButton(
                    text = "Home",
                    onClick = onClickBackToHome,
                    buttonColor = CardBackgroundColor,
                    textColor = White_FF
                )
            }
            SpacerHorizontal12()
            Box(modifier = Modifier.weight(1f)) {
                CustomButton(
                    text = "Play again",
                    onClick = onClickBackToGame,
                    buttonColor = Secondary,
                    textColor = Black_60
                )

            }
            SpacerVertical16()

        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewGameScreen() {
//    GameScreen()
}
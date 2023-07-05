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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R
import com.example.triviagame.ui.composable.ActionButton
import com.example.triviagame.ui.composable.ImageButton
import com.example.triviagame.ui.composable.OutlinePlayButton
import com.example.triviagame.ui.composable.PlayButton


@Composable
fun PlayScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF601B6D))
            .padding(16.dp),
    ) {

        Header()

        Spacer(Modifier.height(24.dp))

        PlayContent()

        Spacer(Modifier.height(32.dp))

        PlayButtons()

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            ActionButton(
                text = "Next", onClick = {}, modifier = Modifier
                    .height(54.dp)
                    .width(186.dp)
            )
        }


    }

}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageButton(R.drawable.arrow_left, backgroundColor = Color(0xFF6F2F7B)) {}
        ImageButton(R.drawable.arrow_left, text = "321000") {}
    }
}

@Composable
private fun PlayContent() {
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
                        .background(Color(0xFF6F2F7B))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "30",
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                color = Color(0xFF6F2F7B), shape = CircleShape
                            )
                            .border(
                                width = 6.dp, color = Color(0xFFC8C4F0), shape = CircleShape
                            )
                            .padding(22.dp),
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "What microbes are used to\nbreak down plant matter for\ncomposting?",
                        color = Color.White,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ImageButton(
                            painter = R.drawable.arrow_square_left, iconTint = Color(0xFFC8C4F0)
                        ) {}
                        ImageButton(
                            painter = R.drawable.arrow_square_right, iconTint = Color(0xFFC8C4F0)
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
                    .background(Color(0xFFC8C4F0))
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Question", fontSize = 16.sp)
                Text(text = "7/10", fontSize = 16.sp)
            }
        }

    }

}

@Composable
private fun PlayButtons() {
    OutlinePlayButton(text = "Bacteria", onClick = {})
    Spacer(Modifier.height(16.dp))
    PlayButton(text = "Mold", onClick = {})
    Spacer(Modifier.height(16.dp))
    OutlinePlayButton(text = "Fungus", buttonColor = Color(0xFFB72525), onClick = {})
    Spacer(Modifier.height(16.dp))
    PlayButton(text = "Algae", onClick = {}, buttonColor = Color(0xFF56AE67))
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPlayScreen() {
    PlayScreen()
}
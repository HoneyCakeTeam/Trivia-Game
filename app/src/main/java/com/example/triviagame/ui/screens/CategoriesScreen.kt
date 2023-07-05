package com.example.triviagame.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CategoriesScreen() {
    Column(
        Modifier
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Header()
        Text(
            text = "Choose your game type",
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
        )
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "user",
            modifier = Modifier.size(40.dp)
        )
        Box {
            Text(
                text = "32100",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
               fontFamily = FontFamily(Font(R.font.montserrat_semibold)
            ))
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "arrow left",
                modifier = Modifier.padding(start = 48.dp)
            )

        }

    }
}


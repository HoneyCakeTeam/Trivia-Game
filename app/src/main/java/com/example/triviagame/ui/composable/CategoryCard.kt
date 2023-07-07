package com.example.triviagame.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R

@Composable
fun CategoryCard(
    CategoryImage: Int ,
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
         contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .size(156.dp, 120.dp),
            colors = CardDefaults.cardColors(com.example.triviagame.ui.theme.Card)
        ) {}
        Card(
            modifier = Modifier
                .size(80.dp)
                .offset(0.dp, (-32).dp).background(Color.Transparent),
            colors = CardDefaults.cardColors(Color.Transparent)

        ) {
            Image(painter = painterResource(id = CategoryImage),
                contentDescription ="category",modifier = Modifier
                    .fillMaxSize(),)
        }
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 80.dp, start = 8.dp)
        )
    }

}

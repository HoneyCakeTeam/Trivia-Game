package com.example.triviagame.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.R

@Preview
@Composable
fun CategoryCard(
    CategoryImage: Int = R.drawable.history,
    text: String = "History"
) {
    Box(modifier = Modifier.background(Color.Transparent).fillMaxSize().padding(16.dp)){
    Card(
        modifier = Modifier
            .size(156.dp, 120.dp),
        colors = CardDefaults.cardColors(com.example.triviagame.ui.theme.Card)
    )
    {
        Box(
            modifier = Modifier
                .padding(start = 39.dp)
                .size(156.dp, 120.dp)
                .background(com.example.triviagame.ui.theme.Card)
        ) {

            Image(
                painter = painterResource(id = CategoryImage),
                contentDescription = "category", modifier = Modifier
                    .size(80.dp).offset(y = (-40).dp)

            )
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
}}
package com.example.triviagame.ui.composable

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.ui.theme.Black_60
import com.example.triviagame.ui.theme.Montserrat
import com.example.triviagame.ui.theme.Secondary

@Composable
fun PrimaryButton(text : String,onClick:() -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Secondary),
        modifier = modifier.height(54.dp)

    ){
        Text(
            text = text,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Black_60
        )
    }
}

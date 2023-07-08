package com.example.triviagame.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@Composable
fun TextLabel(text:String){
    Text(
        text = text,
        style = Typography.titleMedium,
        color = White_FF,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}


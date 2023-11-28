package com.honey.triviagame.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.theme.White_FF

@Composable
fun TextLabel(text:String){
    Text(
        text = text,
        style = Typography.titleMedium,
        color = White_FF,
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        textAlign = TextAlign.Start
    )
}



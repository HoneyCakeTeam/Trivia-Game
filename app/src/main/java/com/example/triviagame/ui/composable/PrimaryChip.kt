package com.example.triviagame.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.triviagame.ui.theme.Montserrat
import com.example.triviagame.ui.theme.Primary
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.White_FF

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryChip(
    text: String,
    selected: Boolean,
    onChipState: (String) -> Unit
) {
    SuggestionChip(onClick = {
        if (!selected)
            onChipState(text)
        else
            onChipState("")
    }, label = {
        Text(
            text = text,
            color = White_FF,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
    },
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.5.dp,
            borderColor = if (selected) Color.Transparent else Secondary
        ),
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) Primary else Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp)
    )

}
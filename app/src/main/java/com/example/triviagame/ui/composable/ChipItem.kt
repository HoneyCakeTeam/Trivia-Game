package com.example.triviagame.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.theme.Black_87
import com.example.triviagame.ui.theme.RoundedShape
import com.example.triviagame.ui.theme.Secondary
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipItem(
    text: String,
    selected: Boolean,
    onClickChip: (String) -> Unit,
    onColor: () -> Unit,

    ) {
    val chipContainerColor by animateColorAsState(
        if (selected) Secondary else Color.Transparent,
        tween(300)
    )
    val chipBorderColor by animateColorAsState(
        if (selected) Color.Transparent else Secondary,
        tween(300)
    )
    val chipTextColor by animateColorAsState(
        if (selected) Black_87 else White_FF,
        tween(300)
    )
    SuggestionChip(
        onClick = {
            if (!selected) {
                onClickChip(text)
                onColor()
            }
        }, label = {
            Text(
                text = text,
                color = chipTextColor,
                style = Typography.bodyMedium,
            )
        },
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.5.dp,
            borderColor = chipBorderColor
        ),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = chipContainerColor
        ),
        shape = RoundedShape.medium
    )
}
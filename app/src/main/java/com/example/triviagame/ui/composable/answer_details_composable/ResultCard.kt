package com.example.triviagame.ui.composable.answer_details_composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.screens.game_result.composable.TextResult
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Typography

@Composable
fun ReusableCard(
    modifier: Modifier = Modifier,
    labelText: String,
    questionCount: String,
    circleColor: Color,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = CardBackgroundColor)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(6.dp).clip(CircleShape).background(circleColor))
                TextResult(text = labelText, style = Typography.bodyMedium)
            }
            TextResult(text = questionCount, style = Typography.bodyLarge)
        }
    }
}

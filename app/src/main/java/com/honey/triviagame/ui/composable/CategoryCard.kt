package com.honey.triviagame.ui.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honey.triviagame.ui.screens.categories.CategoryUiState
import com.honey.triviagame.ui.theme.CardBackgroundColor
import com.honey.triviagame.ui.theme.Secondary
import com.honey.triviagame.ui.theme.Typography
import com.honey.triviagame.ui.theme.White_FF

@Composable
fun CategoryCard(
    onClickCategory: (CategoryUiState) -> Unit,
    category: CategoryUiState,
    modifier: Modifier = Modifier
    ) {
    val cardColor by animateColorAsState(
        if (category.selected) Secondary else CardBackgroundColor,
        tween(300), label = "Chip Color Animation"
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onClickCategory(category)
            },
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(cardColor)
        ) { }
        Card(
            modifier = Modifier
                .size(80.dp)
                .offset(0.dp, (-32).dp)
                .background(Transparent),
            colors = CardDefaults.cardColors(Transparent)

        ) {
            Image(
                painter = painterResource(id = category.categoryImage),
                contentDescription = "category",
                modifier = Modifier.fillMaxSize(),
            )
        }
        Text(
            text = category.category.categoryName,
            style = Typography.titleMedium,
            color = White_FF,
            modifier = Modifier.padding(top = 80.dp, start = 8.dp)
        )
    }
}

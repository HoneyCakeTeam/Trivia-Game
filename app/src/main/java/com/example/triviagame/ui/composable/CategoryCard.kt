package com.example.triviagame.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.triviagame.ui.screens.categories.CategoryUiState
import com.example.triviagame.ui.theme.CardBackgroundColor
import com.example.triviagame.ui.theme.Typography
import com.example.triviagame.ui.theme.White_FF

@Composable
fun CategoryCard(
    category: CategoryUiState,
    onClickCategory: (CategoryUiState) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .size(156.dp, 120.dp)
                .clickable { onClickCategory(category) },
            colors = CardDefaults.cardColors(CardBackgroundColor)
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
            text = category.categoryName,
            style = Typography.titleMedium,
            color = White_FF,
            modifier = Modifier.padding(top = 80.dp, start = 8.dp)
        )
    }
}

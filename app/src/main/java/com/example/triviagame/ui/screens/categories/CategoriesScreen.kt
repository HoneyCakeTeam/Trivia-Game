package com.example.triviagame.ui.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.triviagame.R
import com.example.triviagame.ui.composable.BottomSheet
import com.example.triviagame.Screen
import com.example.triviagame.ui.composable.CategoryCard
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.screens.categories.composable.CategoryTitle
import com.example.triviagame.ui.screens.categories.composable.Header


@Preview
@Composable
fun CategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    CategoriesContent(state = state,
        onClick = viewModel::onClickCategory,
        onClickChip = viewModel::onClickDiffcultliyChip)
}

@Composable
fun CategoriesContent(
    state: CategoriesUiState,
    onClick: (CategoryUiState) -> Unit,
    onClickChip: (String) -> Unit
) {
    Column(
        Modifier
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(score = state.userScore, modifier = Modifier.padding(horizontal = 16.dp))
        SpacerVertical16()
        CategoryTitle()
        SpacerVertical16()
        LazyGrid(category = state, onClick = onClick)
        BottomSheet(onClick = onClickChip)
    }
}

@Composable
private fun LazyGrid(
    category: CategoriesUiState,
    onClick: (CategoryUiState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(count = category.categories.size) { index ->
            if (index % 2 == 0) { // Even index, place in the first column
                CategoryCard(
                    category = category.categories[index],
                    onClickCategory = onClick
                )
            } else { // Odd index, place in the second column
                Column(modifier = Modifier.padding(top = 32.dp)) {
                    CategoryCard(
                        category = category.categories[index],
                        onClickCategory = onClick
                    )
                }
            }
        }
    }
}
package com.example.triviagame.ui.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.composable.CategoryCard
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.screens.categories.composable.CategoryTitle
import com.example.triviagame.ui.screens.categories.composable.Header
import com.example.triviagame.ui.viewmodel.TriviaGameViewModel


@Preview
@Composable
fun CategoriesScreen(viewModel: TriviaGameViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    CategoriesContent(state = state)
}

@Composable
fun CategoriesContent(
    state: CategoriesUiState,
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
        Header(score = 321000, modifier = Modifier.padding(horizontal = 16.dp))
        SpacerVertical16()
        CategoryTitle()
        SpacerVertical16()
        LazyGrid(category = state)
    }
}

@Composable
private fun LazyGrid(
    category: CategoriesUiState,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(category.categories) {
            CategoryCard(category = it, onClickCategory = { })
        }
    }
}
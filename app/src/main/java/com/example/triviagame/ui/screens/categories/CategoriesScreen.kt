package com.example.triviagame.ui.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.composable.BottomSheet
import com.example.triviagame.ui.composable.CategoryCard
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.screens.categories.composable.CategoryTitle
import com.example.triviagame.ui.screens.categories.composable.Header


@Preview
@Composable
fun CategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    CategoriesContent(
        state = state,
        onClick = viewModel::onClickCategory,
        onClickChip = viewModel::onClickDifficultyChip,
        onClickPlay = { name, level ->
            navController.navigateToPlay(name = name, level = level)
        }
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoriesContent(
    state: CategoriesUiState,
    onClick: (CategoryUiState) -> Unit,
    onClickChip: (String) -> Unit,
    onClickPlay: (String, String) -> Unit
) {
    val bottomSheetState =
        rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState =
        rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,
        sheetContent = {
            BottomSheet(onClick = onClickChip)
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),

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
            LaunchedEffect(key1 = state.selectedCategoryName) {
                if (state.selectedCategoryName.isNotEmpty()) {
                    bottomSheetState.expand()
                } else {
                    bottomSheetState.collapse()
                }
            }
        }
    }
}


@Composable
private fun LazyGrid(
    category: CategoriesUiState,
    onClick: (CategoryUiState) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(category.categories.size) { index ->
            if (index % 2 == 0) { // Even index, place in the first column
                CategoryCard(
                    onClickCategory = onClick,
                    category = category.categories[index],
                )
            } else { // Odd index, place in the second column
                Column(modifier = Modifier.padding(top = 32.dp)) {
                    CategoryCard(
                        category = category.categories[index],
                        onClickCategory = onClick,
                    )
                }
            }
        }
    }
}
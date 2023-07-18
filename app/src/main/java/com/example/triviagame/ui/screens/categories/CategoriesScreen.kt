package com.example.triviagame.ui.screens.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.triviagame.ui.LocalNavigationProvider
import com.example.triviagame.ui.composable.ApplicationScaffold
import com.example.triviagame.ui.composable.LevelSelectorBottomSheet
import com.example.triviagame.ui.composable.CategoryCard
import com.example.triviagame.ui.composable.spacing.padding_vertical.SpacerVertical16
import com.example.triviagame.ui.screens.categories.composable.CategoryTitle
import com.example.triviagame.ui.screens.categories.composable.Header
import com.example.triviagame.ui.screens.play.navigateToPlay

@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavigationProvider.current

    CategoriesContent(
        state = state,
        onClick = viewModel::onClickCategory,
        onClickLevel = viewModel::onClickDifficultyChip,
        onClickPlay = { categoryName, level ->
            if (level.isNotEmpty()) {
                navController.navigateToPlay(categoryName = categoryName, level = level)
                viewModel.emptyState()
            }
        }
    )
}




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoriesContent(
    state: CategoriesUiState,

    onClick: (CategoryUiState) -> Unit,
    onClickLevel: (String) -> Unit,
    onClickPlay: (String, String) -> Unit,
) {
    val bottomSheetState =
        rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState =
        rememberBottomSheetScaffoldState(bottomSheetState = bottomSheetState)
    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,
        sheetContent = {
            LevelSelectorBottomSheet(onClick = onClickLevel, onClickPlay = onClickPlay, state = state)
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) {
        ApplicationScaffold {
            Header(score = state.userScore, modifier = Modifier.padding(horizontal = 16.dp))
            SpacerVertical16()
            CategoryTitle()
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                items(state.categories.size) { index ->
                    Column(
                        modifier = if (index % 2 == 0) Modifier else
                            Modifier.padding(top = 32.dp)
                    ) {
                        CategoryCard(
                            onClickCategory = onClick,
                            category = state.categories[index],
                        )
                    }
                }
            }
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



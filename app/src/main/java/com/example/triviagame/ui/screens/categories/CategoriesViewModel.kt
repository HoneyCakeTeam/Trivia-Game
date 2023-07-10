package com.example.triviagame.ui.screens.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.triviagame.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(CategoriesUiState())
    val state = _state.asStateFlow()


    init {
        getCategoryDetails()
    }

    fun onClickCategory(selectedCategory: CategoryUiState) {
        var selectedCategoryName = ""
        _state.update {
            it.copy(
                categories = it.categories.map { category ->
                    if (!category.selected && category == selectedCategory) {
                        category.copy(selected = true).also {
                            selectedCategoryName = selectedCategory.categoryName
                        }
                    } else {
                        category.copy(selected = false)
                    }
                },
                selectedCategoryName = selectedCategoryName
            )
        }
        Log.e("CategoriesViewModel", "onClickCategory: ${selectedCategoryName}")
    }

    fun onClickDifficultyChip(difficulty: String) {
        _state.update {
            it.copy(
                selectedDifficulty = difficulty
            )
        }
    }


    private fun getCategoryDetails() {
        _state.update {
            it.copy(
                categories = listOf(
                    CategoryUiState(
                        categoryName = "food_and_drink",
                        categoryImage = R.drawable.food_and_drink,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "geography", categoryImage = R.drawable.geo,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "film_and_tv,music",
                        categoryImage = R.drawable.smart_tv,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "history", categoryImage = R.drawable.history,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "general_knowledge",
                        categoryImage = R.drawable.knowledge,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "art_and_literature",
                        categoryImage = R.drawable.literature,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "science", categoryImage = R.drawable.science,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "society", categoryImage = R.drawable.society,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "sport_and_leisure",
                        categoryImage = R.drawable.sport,
                        selected = false
                    ),
                    CategoryUiState(
                        categoryName = "music", categoryImage = R.drawable.music,
                        selected = false
                    ),
                ),
            )
        }
    }

    fun onCategorySelected(selectedCategory: CategoryUiState) {

    }
}
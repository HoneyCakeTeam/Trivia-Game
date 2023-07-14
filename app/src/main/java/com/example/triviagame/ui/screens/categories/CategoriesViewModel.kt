package com.example.triviagame.ui.screens.categories

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
                            selectedCategoryName = selectedCategory.category.categoryId
                        }
                    } else {
                        category.copy(selected = false)
                    }
                },
                selectedCategoryName = selectedCategoryName
            )
        }
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
                        category = Category(
                            categoryId = "food_and_drink",
                            categoryName = "Food & Drink"
                        ),
                        categoryImage = R.drawable.food_and_drink,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(categoryId = "geography", categoryName = "Geography"),
                        categoryImage = R.drawable.geo,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(
                            categoryId = "film_and_tv,music",
                            categoryName = "Tv & Film "
                        ),
                        categoryImage = R.drawable.smart_tv,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(categoryId = "history", categoryName = "History"),
                        categoryImage = R.drawable.history,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(
                            categoryId = "general_knowledge",
                            categoryName = "General knowledge"
                        ),
                        categoryImage = R.drawable.knowledge,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(
                            categoryId = "art_and_literature",
                            categoryName = "Art & Literature"
                        ),
                        categoryImage = R.drawable.literature,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(categoryId = "science", categoryName = "Science"),
                        categoryImage = R.drawable.science,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(categoryId = "society", categoryName = "Society"),
                        categoryImage = R.drawable.society,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(
                            categoryId = "sport_and_leisure",
                            categoryName = "Sport & Leisure"
                        ),
                        categoryImage = R.drawable.sport,
                        selected = false
                    ),
                    CategoryUiState(
                        category = Category(categoryId = "music", categoryName = "Music"),
                        categoryImage = R.drawable.music,
                        selected = false
                    ),
                ),
            )
        }
    }
}
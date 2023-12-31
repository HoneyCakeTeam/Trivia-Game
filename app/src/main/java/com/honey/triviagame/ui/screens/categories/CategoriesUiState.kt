package com.honey.triviagame.ui.screens.categories


data class CategoriesUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String? = "",
    val userScore: Int = 0,
    val selectedCategoryName: String = "",
    val categories: List<CategoryUiState> = emptyList(),
    val selectedDifficulty: String = "",
)


data class CategoryUiState(
    val category: Category = Category(),
    val categoryImage: Int = 0,
    val categoryDifficulty: String = "",
    val selected: Boolean,
)

data class Category(val categoryId: String = "", val categoryName: String = "")

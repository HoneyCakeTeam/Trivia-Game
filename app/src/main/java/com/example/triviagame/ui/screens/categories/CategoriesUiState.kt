package com.example.triviagame.ui.screens.categories


data class CategoriesUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String? = "",
    val userScore: Int = 0,
    val categories: List<CategoryUiState> = emptyList(),
    val selectedDifficulty: String = "",
)


data class CategoryUiState(
    val categoryName: String = "",
    val categoryImage: Int = 0,
)
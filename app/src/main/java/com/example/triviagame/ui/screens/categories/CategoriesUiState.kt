package com.example.triviagame.ui.screens.categories

/**
 * Created by Aziza Helmy on 7/4/2023.
 */
data class CategoriesUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String? = "",
    val userScore: Int = 0,
    val categories: List<CategoryUiState> = emptyList()
)


data class CategoryUiState(
    val categoryName: String = "",
    val categoryImage: Int = 0
)
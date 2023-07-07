package com.example.triviagame.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.screens.categories.CategoriesUiState
import com.example.triviagame.ui.screens.categories.CategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TriviaGameViewModel @Inject constructor() : ViewModel() {

    protected val _state = MutableStateFlow(CategoriesUiState())
    val state = _state.asStateFlow()

    init {
        getCategoryImages()
    }

    private fun getCategoryImages() {
        _state.update {
            it.copy(
                categories = listOf(
                    CategoryUiState(categoryName = "Food", categoryImage = R.drawable.food_and_drink),
                    CategoryUiState(categoryName = "Geographical", categoryImage = R.drawable.geo),
                    CategoryUiState(categoryName = "Film & Tv", categoryImage = R.drawable.smart_tv),
                    CategoryUiState(categoryName = "History", categoryImage = R.drawable.history),
                    CategoryUiState(categoryName = "General Knowledge", categoryImage = R.drawable.knowledge),
                    CategoryUiState(categoryName = "Literature", categoryImage = R.drawable.literature),
                    CategoryUiState(categoryName = "Science", categoryImage = R.drawable.science),
                    CategoryUiState(categoryName = "Society", categoryImage = R.drawable.society),
                    CategoryUiState(categoryName = "Sport", categoryImage = R.drawable.sport),
                    CategoryUiState(categoryName = "Music", categoryImage = R.drawable.music),
                ),
            )
        }
    }
}



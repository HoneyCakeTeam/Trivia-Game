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

    fun onClickCategory(category: CategoryUiState) {
        _state.update {
            it.copy(selectedCategoryName = category.categoryName)
        }
    }

     fun onClickDiffcultliyChip(diffcultliy: String) {
        _state.update {
            it.copy(
                selectedDifficulty =diffcultliy
            )
        }
    }


    private fun getCategoryDetails() {
        _state.update {
            it.copy(
                categories = listOf(
                    CategoryUiState(
                        categoryName = "food_and_drink",
                        categoryImage = R.drawable.food_and_drink
                    ),
                    CategoryUiState(categoryName = "geography", categoryImage = R.drawable.geo),
                    CategoryUiState(
                        categoryName = "film_and_tv,music",
                        categoryImage = R.drawable.smart_tv
                    ),
                    CategoryUiState(categoryName = "history", categoryImage = R.drawable.history),
                    CategoryUiState(
                        categoryName = "general_knowledge",
                        categoryImage = R.drawable.knowledge
                    ),
                    CategoryUiState(
                        categoryName = "art_and_literature",
                        categoryImage = R.drawable.literature
                    ),
                    CategoryUiState(categoryName = "science", categoryImage = R.drawable.science),
                    CategoryUiState(categoryName = "society", categoryImage = R.drawable.society),
                    CategoryUiState(
                        categoryName = "sport_and_leisure",
                        categoryImage = R.drawable.sport
                    ),
                    CategoryUiState(categoryName = "music", categoryImage = R.drawable.music),
                ),
            )
        }
    }
}
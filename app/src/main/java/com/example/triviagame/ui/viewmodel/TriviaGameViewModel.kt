package com.example.triviagame.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.triviagame.R
import com.example.triviagame.ui.viewmodel.state.CategoriesUiState
import com.example.triviagame.ui.viewmodel.state.categoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TriviaGameViewModel @Inject constructor() :ViewModel(){

    protected val _state = MutableStateFlow(CategoriesUiState())
    val state = _state.asStateFlow()

    init {
        getCategoryImages()
    }
    private fun getCategoryImages() {
        _state.update {
it.copy(
    CategoreyList =  listOf(
        categoryList(name = "Food", image = R.drawable.food),
        categoryList(name = "Geographical", image = R.drawable.geo),
        categoryList(name = "tv", image = R.drawable.tv),
        categoryList(name = "history", image = R.drawable.history),
        categoryList(name = "General Knowledge", image = R.drawable.knowledge),
        categoryList(name = "literature", image = R.drawable.literature),
        categoryList(name = "science", image = R.drawable.science),
        categoryList(name = "society", image = R.drawable.society),
        categoryList(name = "sport", image = R.drawable.sport),
            ),)
        }
        }
    }



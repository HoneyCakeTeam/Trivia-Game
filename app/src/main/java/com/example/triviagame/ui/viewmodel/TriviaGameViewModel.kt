package com.example.triviagame.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.screens.play.toQuestionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaGameViewModel @Inject constructor(
    private val repository: TriviaRepository
) : ViewModel() {
    private val _state = MutableStateFlow(PlayUiState())
    val state = _state.asStateFlow()

    init {
        getTriviaQuestions("food_and_drink","easy")
    }

    private fun getTriviaQuestions(
        category: String,
        difficulty: String
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    questions = repository.getTriviaQuestions(
                        category,
                        difficulty
                    ).map { it.toQuestionUiState() }
                )
            }
        }


    }
}



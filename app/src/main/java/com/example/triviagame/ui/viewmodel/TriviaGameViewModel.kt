package com.example.triviagame.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.screens.answer_details.AnswersUiState
import com.example.triviagame.ui.screens.play.PlayArgs
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.util.COUNTER_COUNT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TriviaGameViewModel @Inject constructor(
    private val repository: TriviaRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(PlayUiState())
    val state = _state.asStateFlow()

    private val _resultState = MutableStateFlow(AnswersUiState())
    val resultState = _resultState.asStateFlow()

    val args = PlayArgs(savedStateHandle)

    init {
        getTriviaQuestions()
    }

    fun getTriviaQuestions() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                _state.update { playUiState ->
                    playUiState.copy(
                        timer = COUNTER_COUNT,
                        isLoading = false,
                        currentQuestionIndex = 0,
                    )
                }
            } catch (e: Exception) {
                Log.e("Exception", "getTriviaQuestions: ${e.message}")
            }
        }
    }


    fun savePoint(points: Int) {
        viewModelScope.launch {
            if (points >= 50) {
                repository.savePints(points)
            } else {
                repository.getPoints()
            }
        }
    }

}



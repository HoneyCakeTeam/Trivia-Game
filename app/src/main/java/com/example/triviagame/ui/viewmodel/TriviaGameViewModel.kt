package com.example.triviagame.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.screens.play.PlayArgs
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.screens.play.toQuestionUiState
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

    private val args = PlayArgs(savedStateHandle)

    init {
        getTriviaQuestions(args.name, args.level)
    }

    private fun getTriviaQuestions(
        category: String,
        difficulty: String,
    ) {
        _state.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            _state.update { playUiState ->
                playUiState.copy(
                    timer = COUNTER_COUNT,
                    isLoading = false,
                    questions = repository.getTriviaQuestions(
                        category,
                        difficulty
                    ).map { it.toQuestionUiState() }
                )
            }
        }
    }

    fun onClickAnswer(answer: String) {
        _state.update {
            it.copy(
                timer = 0L,
                questions = _state.value.questions.mapIndexed { index, question ->
                    if (index == state.value.currentQuestionIndex) {
                        question.copy(selectedAnswer = answer, enabled = false)
                    } else {
                        question
                    }
                }
            )
        }
    }

    fun onClickNext() {
        _state.update {
            it.copy(
                timer = COUNTER_COUNT,
                currentQuestionIndex = state.value.currentQuestionIndex + 1
            )
        }
    }
}



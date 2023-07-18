package com.example.triviagame.ui.screens.game_result

import androidx.lifecycle.viewModelScope
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class GameResultViewModel @Inject constructor(private val repository: TriviaRepository) :
    BaseViewModel<GameResultUiState>(GameResultUiState()), GameResultInteractionsListener {
    init {
        getResults()
    }

    private fun getResults() {
        _state.update {
            it.copy(
                totalQuestions = repository.getQuestionAnswers().size,
                totalAnswers = repository.getCorrectAnswersCount()
            )
        }
        calculateAnswersState()
    }

    private fun calculateAnswersState() {
        _state.update { answersUiState ->
            answersUiState.copy(
                correctAnswersCount = repository.getCorrectAnswersCount(),
                incorrectAnswersCount = repository.getIncorrectAnswersCount(),
                skippedAnswersCount = repository.getSkippedAnswersCount()
            )
        }
        saveHighestScore()
    }

    private fun saveHighestScore() {
        viewModelScope.launch {
            repository.saveHighestScore(state.value.correctAnswersCount * 10)
        }
    }
}
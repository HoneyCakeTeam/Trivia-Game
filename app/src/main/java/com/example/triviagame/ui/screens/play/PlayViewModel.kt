package com.example.triviagame.ui.screens.play

import androidx.lifecycle.SavedStateHandle
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import com.example.triviagame.ui.util.COUNTER_COUNT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class PlayViewModel @Inject constructor(
    private val repository: TriviaRepository,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PlayUiState>(PlayUiState()), PlayInteractionsListener {

    val args = PlayArgs(savedStateHandle)

    init {
        getTriviaQuestions()
    }

    fun getTriviaQuestions() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            {
                repository.getTriviaQuestions(args.name, args.level).map { it.toQuestionUiState() }
            },
            ::onGetQuestionsSuccess,
            ::onGetQuestionsFail
        )
    }

    private fun onGetQuestionsSuccess(questions: List<QuestionUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                questions = questions,
                timer = COUNTER_COUNT,
                currentQuestionIndex = 0
            )
        }
    }

    private fun onGetQuestionsFail(error: Exception) {
        _state.update { it.copy(isLoading = false) }
    }

}
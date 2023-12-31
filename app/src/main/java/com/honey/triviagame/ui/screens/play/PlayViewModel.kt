package com.honey.triviagame.ui.screens.play

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.honey.triviagame.data.repository.TriviaRepository
import com.honey.triviagame.ui.BaseViewModel
import com.honey.triviagame.ui.screens.answer_details.AnswerUiState
import com.honey.triviagame.ui.util.COUNTER_COUNT
import com.honey.triviagame.ui.util.NUMBER_OF_QUESTIONS
import com.honey.triviagame.ui.util.QuestionState
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

    private val args = PlayArgs(savedStateHandle)

    fun refreshTriviaQuestions() {
        _state.update { it.copy(isLoading = true, isError = false) }
        tryToExecute(
            {
                repository.refreshTriviaQuestions(args.name, args.level)
            },
            ::onRefreshQuestionsSuccess,
            ::onRefreshQuestionsFail
        )
    }

    private fun onRefreshQuestionsSuccess(unit: Unit) {
        _state.update {
            it.copy(
                isLoading = false,
                timer = COUNTER_COUNT,
                currentQuestionIndex = 0
            )
        }
        getQuestionByIndex(state.value.currentQuestionIndex)
    }

    private fun onRefreshQuestionsFail(error: Exception) {
        _state.update { it.copy(isLoading = false) }
    }

    private fun getQuestionByIndex(index: Int) {
        tryToExecute(
            { repository.getQuestionByIndex(index).toQuestionUiState() },
            ::onGetQuestionSuccess,
            ::onGetQuestionError
        )
    }

    private fun onGetQuestionSuccess(question: QuestionUiState) {
        _state.update {
            it.copy(
                question = question
            )
        }
    }

    private fun onGetQuestionError(error: Exception) {
        //todo
    }

    override fun onClickAnswer(answer: String) {
        _state.update {
            it.copy(
                timer = -1L,
                question = _state.value.question.copy(selectedAnswer = answer, enabled = false)
            )
        }
    }

    override fun onClickNext() {
        saveCurrentQuestionResult()
        _state.update {
            it.copy(
                timer = COUNTER_COUNT,
                currentQuestionIndex = state.value.currentQuestionIndex + 1
            )
        }
        getQuestionByIndex(
            state.value.currentQuestionIndex
        )
    }



    fun saveCurrentQuestionResult() {
        val question = state.value.question
        cacheQuestionAnswer(
            AnswerUiState(
                state = getQuestionState(question.selectedAnswer, question.correctAnswer),
                questionText = question.questionText,
                userAnswer = question.selectedAnswer,
                correctAnswer = question.correctAnswer,
                type = args.name
            )
        )
        Log.e("saveCurrentQuestionResult", "saveCurrentQuestionResult: ${state.value.currentQuestionIndex}" )
    }

    private fun cacheQuestionAnswer(question: AnswerUiState) {
        repository.putQuestionAnswer(state.value.currentQuestionIndex, question)
    }

    private fun getQuestionState(answer: String, correctAnswer: String): QuestionState {
        return when (answer) {
            "" -> {
                QuestionState.NOT_ANSWERED
            }

            correctAnswer -> {
                QuestionState.CORRECT
            }

            else -> {
                QuestionState.WRONG
            }
        }
    }

    fun resetQuestionState() {
        _state.update {
            it.copy(
                currentQuestionIndex = -1
            )
        }
    }

     fun getNextButtonText(){
        val text= if (state.value.currentQuestionIndex < NUMBER_OF_QUESTIONS - 1) {
            "Next"
        } else {
            "Submit"
        }
        _state.update {
            it.copy(
                buttonText = text
            )
        }
    }

}
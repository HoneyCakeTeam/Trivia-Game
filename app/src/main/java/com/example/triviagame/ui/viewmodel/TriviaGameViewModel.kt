package com.example.triviagame.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.screens.answer_details.AnswersUiState
import com.example.triviagame.ui.screens.play.PlayArgs
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.screens.play.toQuestionUiState
import com.example.triviagame.ui.util.COUNTER_COUNT
import com.example.triviagame.ui.util.QuestionState
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
            try {
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
            } catch (e: Exception) {
                Log.e("Exception", "getTriviaQuestions: ${e.message}")
            }
        }
    }

    fun onClickAnswer(answer: String) {
        _state.update {
            it.copy(
                timer = -1L,
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
        addCurrentQuestionResult()
        _state.update {
            it.copy(
                timer = COUNTER_COUNT,
                currentQuestionIndex = state.value.currentQuestionIndex + 1
            )
        }
    }

    fun addCurrentQuestionResult() {
        val question = state.value.questions[state.value.currentQuestionIndex]
        addQuestion(
            AnswerUiState(
                id = 0,
                state = getQuestionState(question.selectedAnswer, question.correctAnswer),
                question = question.question,
                answer = question.selectedAnswer,
                correctAnswer = question.correctAnswer
            )
        )
    }

    private fun addQuestion(question: AnswerUiState) {
        val updatedQuestions = _resultState.value.questions.toMutableList()
        updatedQuestions.add(question)
        _resultState.value = _resultState.value.copy(questions = updatedQuestions)

        _resultState.update {
            it.copy(
                totalQuestions = _resultState.value.questions.size,
                totalAnswers = resultState.value.questions.count { answer ->
                    answer.state == QuestionState.CORRECT
                }
            )
        }
        calculateAnswersState()
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

    private fun calculateAnswersState() {
        _resultState.update { answersUiState ->
            answersUiState.copy(
                correctAnswers = resultState.value.questions.count {
                    it.state == QuestionState.CORRECT
                },
                wrongAnswers = resultState.value.questions.count {
                    it.state == QuestionState.WRONG
                },
                skippedAnswers = resultState.value.questions.count {
                    it.state == QuestionState.NOT_ANSWERED
                }
            )
        }
    }
}



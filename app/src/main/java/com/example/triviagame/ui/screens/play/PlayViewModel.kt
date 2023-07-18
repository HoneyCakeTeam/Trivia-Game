package com.example.triviagame.ui.screens.play

import androidx.lifecycle.SavedStateHandle
import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.util.COUNTER_COUNT
import com.example.triviagame.ui.util.QuestionState
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

    init {
        getTriviaQuestions()
    }

    private fun getTriviaQuestions() {
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
                timer = COUNTER_COUNT,
                currentQuestionIndex = 0
            )
        }
        repository.cacheQuestions(questions)
        _state.update {
            it.copy(
                question = repository.getQuestionByIndex(
                    state.value.currentQuestionIndex
                )
            )
        }
    }

    private fun onGetQuestionsFail(error: Exception) {
        _state.update { it.copy(isLoading = false) }
    }

    fun onClickAnswer(answer: String) {
        _state.update {
            it.copy(
                timer = -1L,
                question = _state.value.question.copy(selectedAnswer = answer, enabled = false)
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
        _state.update {
            it.copy(
                question = repository.getQuestionByIndex(
                    state.value.currentQuestionIndex
                )
            )
        }
    }

    fun addCurrentQuestionResult() {
        /*val question = state.value.questions[state.value.currentQuestionIndex]
        addQuestion(
            AnswerUiState(
                id = 0,
                state = getQuestionState(question.selectedAnswer, question.correctAnswer),
                question = question.question,
                answer = question.selectedAnswer,
                correctAnswer = question.correctAnswer
            )
        )*/
    }

    private fun addQuestion(question: AnswerUiState) {
        /*val updatedQuestions = _resultState.value.questions.toMutableList()
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
        calculateAnswersState()*/
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
        /*_resultState.update { answersUiState ->
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
        }*/
    }

}
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
import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.screens.play.PlayUiState
import com.example.triviagame.ui.screens.play.QuestionUiState
import com.example.triviagame.ui.util.QuestionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    init {
        _state.update {
            PlayUiState(
                questions = listOf(
                    QuestionUiState(
                        question = "Sample Question 1",
                        answers = listOf(
                            AnswerUiState(
                                id = 1,
                                state = QuestionState.NOT_ANSWERED,
                                question = "Sample Question 1",
                                answer = "Sample Answer 1"
                            ),
                            AnswerUiState(
                                id = 2,
                                state = QuestionState.NOT_ANSWERED,
                                question = "Sample Question 1",
                                answer = "Sample Answer 2"
                            ),
                            AnswerUiState(
                                id = 3,
                                state = QuestionState.NOT_ANSWERED,
                                question = "Sample Question 1",
                                answer = "Sample Answer 3"
                            ),
                            AnswerUiState(
                                id = 4,
                                state = QuestionState.NOT_ANSWERED,
                                question = "Sample Question 1",
                                answer = "Sample Answer 4"
                            )
                        ),
                        correctAnswer = "Sample Answer 1",
                        isAnswered = false,
                        isCorrect = false,
                        questionNumber = 1
                    ),
                    QuestionUiState(
                        question = " Question 2",
                        answers = listOf(
                            AnswerUiState(
                                id = 1,
                                state = QuestionState.NOT_ANSWERED,
                                question = " Question 2",
                                answer = " Answer 1"
                            ),
                            AnswerUiState(
                                id = 2,
                                state = QuestionState.NOT_ANSWERED,
                                question = " Question 2",
                                answer = " Answer 2"
                            ),
                            AnswerUiState(
                                id = 3,
                                state = QuestionState.NOT_ANSWERED,
                                question = " Question 2",
                                answer = " Answer 3"
                            ),
                            AnswerUiState(
                                id = 4,
                                state = QuestionState.NOT_ANSWERED,
                                question = " Question 2",
                                answer = " Answer 4"
                            )
                        ),
                        correctAnswer = " Answer 2",
                        isAnswered = false,
                        isCorrect = false,
                        questionNumber = 2
                    ),
                ),
                numberOfQuestions = 10,
                currentQuestionIndex = 0,
                userScore = 0,
            )
        }
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



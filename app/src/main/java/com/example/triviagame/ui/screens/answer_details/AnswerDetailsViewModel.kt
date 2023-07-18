package com.example.triviagame.ui.screens.answer_details

import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.ui.BaseViewModel
import com.example.triviagame.ui.util.NUMBER_OF_QUESTIONS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */
@HiltViewModel
class AnswerDetailsViewModel @Inject constructor(private val repository: TriviaRepository) :
    BaseViewModel<AnswersUiState>(AnswersUiState()), AnswerDetailsInteractionsListener {

    init {
        _state.update { answersUiState ->
            answersUiState.copy(
                questions = repository.getQuestionAnswers().map { it.toAnswerUiState() },
                totalQuestions = NUMBER_OF_QUESTIONS,
                correctAnswersCount = repository.getCorrectAnswersCount(),
                correctAnswersPercentage = getCorrectAnswerPercentage(),
                inCorrectAnswersPercentage = getInCorrectAnswerPercentage()
            )
        }
    }

    private fun getCorrectAnswerPercentage(): Int {
        return ((repository.getCorrectAnswersCount() / NUMBER_OF_QUESTIONS.toFloat())
                * 100).toInt()
    }

    private fun getInCorrectAnswerPercentage(): Int {
        return 100 - ((repository.getCorrectAnswersCount() / NUMBER_OF_QUESTIONS.toFloat())
                * 100).toInt()
    }
}
package com.example.triviagame.ui.screens.play

import com.example.triviagame.data.source.remote.model.QuestionDto
import com.example.triviagame.ui.screens.answer_details.AnswerUiState

data class PlayUiState(
    val questions: List<QuestionUiState> = emptyList(),//TODO NOT USED
    val numberOfQuestions: Int = 0,
    val currentQuestionIndex: Int = 0,
    val userScore: Int = 0,
)

data class QuestionUiState(
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList(),
    val correctAnswer: String = "",
    val incorrectAnswers: List<String> = emptyList(),
    val selectedAnswer: String = "",
    val isAnswered: Boolean = false,
    val isCorrect: Boolean = false,
    val questionNumber: Int = 0,
    val timer: Long = 30000L
)

fun QuestionDto.toQuestionUiState() =
    QuestionUiState(question = question, incorrectAnswers = incorrectAnswers)


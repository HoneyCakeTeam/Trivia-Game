package com.example.triviagame.ui.screens.play

import com.example.triviagame.data.source.remote.model.QuestionDto

data class PlayUiState(
    val questions: List<QuestionUiState> = emptyList(),//TODO NOT USED
    val numberOfQuestions: Int = 10,
    val currentQuestionIndex: Int = 0,
    val userScore: Int = 0,
    var timer: Long = 0L,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)

data class QuestionUiState(
    val question: String = "",
    val answers: List<String> = emptyList(),
    val correctAnswer: String = "",
    val incorrectAnswers: List<String> = emptyList(),
    val selectedAnswer: String = "",
    val isAnswered: Boolean = false,
    val isCorrect: Boolean = false,
    val enabled: Boolean = true,
)

fun QuestionDto.toQuestionUiState() =
    QuestionUiState(
        question = question.text,
        answers = (incorrectAnswers + correctAnswer).shuffled(),
        incorrectAnswers = incorrectAnswers,
        correctAnswer = correctAnswer
    )


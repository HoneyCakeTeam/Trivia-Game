package com.example.triviagame.data.entity

import com.example.triviagame.data.source.remote.model.QuestionDto

data class QuestionEntity(
    val questionText: String = "",
    val answers: List<String> = emptyList(),
    val correctAnswer: String = "",
    val incorrectAnswers: List<String> = emptyList(),
)

fun QuestionDto.toQuestionEntity() =
    QuestionEntity(
        questionText = question.text,
        answers = (incorrectAnswers + correctAnswer).shuffled(),
        incorrectAnswers = incorrectAnswers,
        correctAnswer = correctAnswer
    )

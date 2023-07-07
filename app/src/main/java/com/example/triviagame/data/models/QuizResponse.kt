package com.example.triviagame.data.models

data class QuizResponse(
    val category: String,
    val correctAnswer: String,
    val difficulty: String,
    val id: String,
    val incorrectAnswers: List<String>,
    val isNiche: Boolean,
    val question: Question,
    val regions: List<String>,
    val tags: List<String>,
    val type: String
)
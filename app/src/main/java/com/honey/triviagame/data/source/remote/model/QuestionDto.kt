package com.honey.triviagame.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class QuestionDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("correctAnswer")
    val correctAnswer: String,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String>,
    @SerializedName("isNiche")
    val isNiche: Boolean,
    @SerializedName("question")
    val question: Question,
    @SerializedName("regions")
    val regions: List<Any>,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("type")
    val type: String
)
data class Question(
    val text:String
)



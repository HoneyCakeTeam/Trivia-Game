package com.example.triviagame.data.source.cash

import com.example.triviagame.ui.screens.play.QuestionUiState

/**
 * Created by Aziza Helmy on 7/15/2023.
 */

interface TriviaCacheManager {
    fun putQuestion(key: Int, value: QuestionUiState)
    fun getQuestion(key: Int): QuestionUiState
    fun removeQuestion(key: Int)
    fun clearAllQuestions()
}
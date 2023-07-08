package com.example.triviagame.data.repository.remote

import com.example.triviagame.data.repository.model.TriviaResponse

interface TriviaService {

    suspend fun getTriviaQuestions(category: String, difficulty: String): List<TriviaResponse>
}
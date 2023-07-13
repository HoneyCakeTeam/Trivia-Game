package com.example.triviagame.data.repository

import com.example.triviagame.data.source.remote.model.QuestionDto
import com.example.triviagame.data.source.remote.network.TriviaService
import javax.inject.Inject

class TriviaRepositoryImp @Inject constructor(
    private val triviaService: TriviaService,
) : TriviaRepository {
    override suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionDto> {
        return triviaService.getTriviaQuestions(category, difficulty)
    }
}
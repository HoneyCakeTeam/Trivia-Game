package com.example.triviagame.data.repository

import com.example.triviagame.data.source.remote.model.QuestionModel
import com.example.triviagame.data.source.remote.network.TriviaService
import javax.inject.Inject

class TriviaRepositoryImp @Inject constructor(
    private val triviaService: TriviaService,
) : TriviaRepository {
    override suspend fun getTriviaQuestions(
        category: String,
        difficulty: String,
    ): List<QuestionModel> {
        return triviaService.getTriviaQuestions(category, difficulty)
    }
}
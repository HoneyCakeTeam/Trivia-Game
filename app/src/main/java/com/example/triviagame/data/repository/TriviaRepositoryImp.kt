package com.example.triviagame.data.repository

import android.util.Log
import com.example.triviagame.data.source.local.DataStorePref
import com.example.triviagame.data.source.remote.model.QuestionDto
import com.example.triviagame.data.source.remote.network.TriviaService
import javax.inject.Inject

class TriviaRepositoryImp @Inject constructor(
    private val triviaService: TriviaService,
    private val datastore: DataStorePref,
    ) : TriviaRepository {
    override suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionDto> {
        return triviaService.getTriviaQuestions(category, difficulty)
    }
    override suspend fun savePints(points: Int) {
        datastore.savePoints(points)
        Log.e("Saved Successfully : ", points.toString())
    }

    override fun getPoints(): String? {
        return datastore.getPoints()
    }
}
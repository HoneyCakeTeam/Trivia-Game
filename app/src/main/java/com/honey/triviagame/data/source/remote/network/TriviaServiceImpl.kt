package com.honey.triviagame.data.source.remote.network

import com.honey.triviagame.data.source.remote.model.QuestionDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import javax.inject.Inject

class TriviaServiceImpl @Inject constructor(
    private val client: HttpClient,
) : TriviaService {

    override suspend fun getTriviaQuestions(
        category: String,
        difficulty: String
    ): List<QuestionDto> {
        val url = URLBuilder(BASE_URL).apply {
            parameters.append(LIMIT, LIMIT_NUMBER)
            parameters.append(TYPE, TYPE_VALUE)
            parameters.append(CATEGORIES, category)
            parameters.append(DIFFICULTIES, difficulty)
        }.buildString()
        return client.get(url).body()
    }

    companion object {
        private const val BASE_URL = "https://the-trivia-api.com/v2/questions?"
        private const val LIMIT_NUMBER = "10"
        private const val LIMIT = "limit"
        private const val TYPE = "types"
        private const val TYPE_VALUE = "text_choice"
        private const val CATEGORIES = "categories"
        private const val DIFFICULTIES = "difficulties"

    }
}



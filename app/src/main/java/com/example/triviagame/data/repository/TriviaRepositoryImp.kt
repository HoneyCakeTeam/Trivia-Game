package com.example.triviagame.data.repository

import android.util.Log
import com.example.triviagame.data.entity.AnswerEntity
import com.example.triviagame.data.entity.QuestionEntity
import com.example.triviagame.data.entity.toAnswerEntity
import com.example.triviagame.data.entity.toQuestionEntity
import com.example.triviagame.data.source.local.cache.CacheManager
import com.example.triviagame.data.source.local.datastore.DataStorePref
import com.example.triviagame.data.source.remote.network.TriviaService
import com.example.triviagame.ui.screens.answer_details.AnswerUiState
import com.example.triviagame.ui.util.QuestionState
import javax.inject.Inject

class TriviaRepositoryImp @Inject constructor(
    private val triviaService: TriviaService,
    private val datastore: DataStorePref,
    private val cacheManager: CacheManager,
) : TriviaRepository, BaseRepository() {
    override suspend fun refreshTriviaQuestions(
        category: String,
        difficulty: String,
    ) {
        try {
            val questions = triviaService.getTriviaQuestions(category, difficulty)
            cacheQuestions(questions.map { it.toQuestionEntity() })
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    override suspend fun saveHighestScore(points: Int) {
        if (getHighestScore() < points) {
            datastore.saveHighestScore(points)
            Log.e("Saved Successfully : ", points.toString())
        }
    }

    override fun getHighestScore(): Int {
        return datastore.getHighestScore() ?: 0
    }

    override fun cacheQuestions(questions: List<QuestionEntity>) {
        clearQuestionsCache()
        questions.forEachIndexed { index, question ->
            cacheManager.putQuestion(index, question)
        }
    }

    override fun putQuestionAnswer(key: Int, value: AnswerUiState) {
        cacheManager.putQuestionAnswer(key, value.toAnswerEntity())
    }

    override fun removeQuestionAnswer(key: Int) {
        cacheManager.removeQuestionAnswer(key)
    }

    override fun clearAllQuestionAnswers() {
        cacheManager.clearAllQuestionAnswers()
    }

    override fun getQuestionAnswers(): List<AnswerEntity> {
        return cacheManager.getQuestionAnswers()
    }

    override fun getQuestionByIndex(index: Int): QuestionEntity {
        return cacheManager.getQuestion(index)
    }

    override fun clearQuestionsCache() {
        cacheManager.clearAllQuestions()
    }

    override fun removeQuestionAt(index: Int) {
        cacheManager.removeQuestion(index)
    }

    override fun getCorrectAnswersCount(): Int {
        val answers = getQuestionAnswers()
        return answers.count {
            it.state == QuestionState.CORRECT
        }
    }

    override fun getIncorrectAnswersCount(): Int {
        val answers = getQuestionAnswers()
        return answers.count {
            it.state == QuestionState.WRONG
        }
    }

    override fun getSkippedAnswersCount(): Int {
        val answers = getQuestionAnswers()
        return answers.count {
            it.state == QuestionState.NOT_ANSWERED
        }
    }
}
package com.honey.triviagame.data.source.local.cache

import android.util.LruCache
import com.honey.triviagame.data.entity.AnswerEntity
import com.honey.triviagame.data.entity.QuestionEntity
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */

class CacheManagerImp @Inject constructor() : CacheManager {
    private val questionsCache = LruCache<Int, QuestionEntity>(1000)
    private val questionResultsCache = LruCache<Int, AnswerEntity>(1000)

    override fun putQuestion(key: Int, value: QuestionEntity) {
        questionsCache.put(key, value)
    }

    override fun getQuestion(key: Int): QuestionEntity {
        return questionsCache[key]
    }

    override fun removeQuestion(key: Int) {
        questionsCache.remove(key)
    }

    override fun clearAllQuestions() {
        questionsCache.evictAll()
    }

    override fun putQuestionAnswer(key: Int, value: AnswerEntity) {
        questionResultsCache.put(key, value)
    }

    override fun getQuestionAnswers(): List<AnswerEntity> {
        return questionResultsCache.snapshot().values.toList()
    }

    override fun removeQuestionAnswer(key: Int) {
        questionResultsCache.remove(key)
    }

    override fun clearAllQuestionAnswers() {
        questionResultsCache.evictAll()
    }

}
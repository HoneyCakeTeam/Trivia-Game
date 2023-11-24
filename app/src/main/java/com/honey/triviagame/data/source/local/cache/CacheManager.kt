package com.honey.triviagame.data.source.local.cache

import com.honey.triviagame.data.entity.AnswerEntity
import com.honey.triviagame.data.entity.QuestionEntity

/**
 * Created by Aziza Helmy on 7/15/2023.
 */

interface CacheManager {
    fun putQuestion(key: Int, value: QuestionEntity)
    fun getQuestion(key: Int): QuestionEntity
    fun removeQuestion(key: Int)
    fun clearAllQuestions()

    fun putQuestionAnswer(key: Int, value: AnswerEntity)
    fun removeQuestionAnswer(key: Int)
    fun clearAllQuestionAnswers()
    fun getQuestionAnswers(): List<AnswerEntity>
}
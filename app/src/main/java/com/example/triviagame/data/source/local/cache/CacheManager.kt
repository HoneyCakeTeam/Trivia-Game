package com.example.triviagame.data.source.local.cache

import com.example.triviagame.data.entity.AnswerEntity
import com.example.triviagame.data.entity.QuestionEntity

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
    fun clearAllQuestionAnswer()
    fun getQuestionAnswer(): List<AnswerEntity>
}
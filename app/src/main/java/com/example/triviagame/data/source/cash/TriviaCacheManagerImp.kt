package com.example.triviagame.data.source.cash

import android.util.Log
import android.util.LruCache
import com.example.triviagame.ui.screens.play.QuestionUiState
import javax.inject.Inject

/**
 * Created by Aziza Helmy on 7/15/2023.
 */

class TriviaCacheManagerImp @Inject constructor() : TriviaCacheManager {
    private val questionsCache = LruCache<Int, QuestionUiState>(1000) //maxSize = 1000

    override fun putQuestion(key: Int, value: QuestionUiState) {
        questionsCache.put(key, value)
        Log.e("lruCache", "put: ${value}")
    }

    override fun getQuestion(key: Int): QuestionUiState {
        return questionsCache[key]
    }

    override fun removeQuestion(key: Int) {
        questionsCache.remove(key)
    }

    override fun clearAllQuestions() {
        questionsCache.evictAll()
    }

}
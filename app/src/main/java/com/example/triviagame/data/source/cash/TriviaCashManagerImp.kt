package com.example.triviagame.data.source.cash

/**
 * Created by Aziza Helmy on 7/15/2023.
 */

class TriviaCashManagerImp<T>  : TriviaCashManager {
 private val cache = HashMap<String, T>()

    fun put(key: String, value: T) {
        cache[key] = value
    }

    fun get(key: String): T? {
        return cache[key]
    }

}
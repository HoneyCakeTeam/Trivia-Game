package com.honey.triviagame.data.repository

abstract class BaseRepository {
    protected suspend fun <T> wrap(function: suspend () -> T): T {
        try {
            return function()
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}
package com.example.triviagame.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class DataStorePrefImp @Inject constructor(context: Context) : DataStorePref {

    companion object {
        private const val PREFERENCES_HIGHEST_SCORE = "Points"
    }

    private val Context.preferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        PREFERENCES_HIGHEST_SCORE
    )

    private val prefDataStore = context.preferencesDataStore
    private val USER_POINTS_KEY = intPreferencesKey(PREFERENCES_HIGHEST_SCORE)


    override suspend fun saveHighestScore(points: Int) {
        prefDataStore.edit { preferences ->
            preferences[USER_POINTS_KEY] = points
        }
    }

    override fun getHighestScore(): Int? {
        return runBlocking {
            prefDataStore.data.map { preferences ->
                preferences[USER_POINTS_KEY]
            }.first()
        }
    }

    override suspend fun clearHighestScore() {
        prefDataStore.edit { preferences ->
            preferences.remove(USER_POINTS_KEY)
        }
    }

}
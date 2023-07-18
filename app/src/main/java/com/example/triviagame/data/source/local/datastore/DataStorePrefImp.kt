package com.example.triviagame.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStorePrefImp @Inject constructor(context: Context) : DataStorePref {

    companion object {
        private const val PREFERENCES_POINTS = "Points"
    }

    private val Context.preferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        PREFERENCES_POINTS
    )

    private val prefDataStore = context.preferencesDataStore
    private val USER_POINTS_KEY = stringPreferencesKey("Points")


    override suspend fun savePoints(points: Int) {
        prefDataStore.edit { preferences ->
            preferences[USER_POINTS_KEY] = points.toString()
        }
    }

    override fun getPoints(): String {
        return prefDataStore.data.map { preferences ->
            preferences[USER_POINTS_KEY]
        }.toString()

    }

    override suspend fun clearPoints() {
        prefDataStore.edit { preferences ->
            preferences.remove(USER_POINTS_KEY)
        }
    }

}
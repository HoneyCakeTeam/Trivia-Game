package com.example.triviagame.di

import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.data.repository.TriviaRepositoryImp
import com.example.triviagame.data.source.local.cache.CacheManagerImp
import com.example.triviagame.data.source.local.datastore.DataStorePref
import com.example.triviagame.data.source.remote.network.TriviaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Aziza Helmy on 7/13/2023.
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun bindTriviaRepository(
        triviaService: TriviaService,
        dataStorePrefImp: DataStorePref,
        triviaCashManagerImp: CacheManagerImp,
    ): TriviaRepository {
        return TriviaRepositoryImp(triviaService, dataStorePrefImp, triviaCashManagerImp)
    }
}
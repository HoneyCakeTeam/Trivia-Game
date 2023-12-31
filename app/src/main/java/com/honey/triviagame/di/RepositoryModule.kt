package com.honey.triviagame.di

import com.honey.triviagame.data.repository.TriviaRepository
import com.honey.triviagame.data.repository.TriviaRepositoryImp
import com.honey.triviagame.data.source.local.cache.CacheManagerImp
import com.honey.triviagame.data.source.local.datastore.DataStorePref
import com.honey.triviagame.data.source.remote.network.TriviaService
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
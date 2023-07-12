package com.example.triviagame.di

import com.example.triviagame.data.repository.TriviaRepository
import com.example.triviagame.data.repository.TriviaRepositoryImp
import com.example.triviagame.data.source.remote.network.TriviaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun bindTriviaGameRepository(
        triviaGameService: TriviaService,
    ): TriviaRepository {
        return TriviaRepositoryImp(triviaGameService)
    }
}
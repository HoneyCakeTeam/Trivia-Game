package com.example.triviagame.di

import android.content.Context
import com.example.triviagame.data.source.local.PointsDataStorePref
import com.example.triviagame.data.source.local.PointsDataStorePrefImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAuthDataStorePref(@ApplicationContext context: Context): PointsDataStorePref {
        return PointsDataStorePrefImp(context)
    }
}
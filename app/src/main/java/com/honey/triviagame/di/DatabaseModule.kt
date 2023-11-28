package com.honey.triviagame.di

import android.content.Context
import com.honey.triviagame.data.source.local.cache.CacheManager
import com.honey.triviagame.data.source.local.cache.CacheManagerImp
import com.honey.triviagame.data.source.local.datastore.DataStorePref
import com.honey.triviagame.data.source.local.datastore.DataStorePrefImp
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
    fun provideDataStorePref(@ApplicationContext context: Context): DataStorePref {
        return DataStorePrefImp(context)
    }

    @Singleton
    @Provides
    fun provideCacheManager(): CacheManager {
        return CacheManagerImp()
    }
}
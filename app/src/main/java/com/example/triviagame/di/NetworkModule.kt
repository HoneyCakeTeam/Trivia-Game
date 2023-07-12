package com.example.triviagame.di

import com.example.triviagame.data.source.remote.network.TriviaService
import com.example.triviagame.data.source.remote.network.TriviaServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.gson.gson
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private const val BASE_URL = "https://the-trivia-api.com/v2/questions?"

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): HttpClient {
        return HttpClient(OkHttp) {
            expectSuccess = true
            engine {
                addInterceptor(loggingInterceptor)
                config {
                    retryOnConnectionFailure(true)
                    connectTimeout(1, TimeUnit.MINUTES)
                    readTimeout(1, TimeUnit.MINUTES)
                    writeTimeout(1, TimeUnit.MINUTES)
                }
            }

            defaultRequest {
                url(BASE_URL)
                header(HttpHeaders.ContentType, "application/json")
            }

            install(ContentNegotiation) {
                gson()
            }
        }

    }

    @Singleton
    @Provides
    fun provideTriviaGameService(httpClient: HttpClient): TriviaService {
        return TriviaServiceImpl(httpClient)
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }
}
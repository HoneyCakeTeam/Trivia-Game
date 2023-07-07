package com.example.triviagame.data.network

import io.ktor.client.HttpClient
import javax.inject.Inject

class TriviaIServiceImpl @Inject constructor(
    private val client: HttpClient,
) : TriviaService {

}
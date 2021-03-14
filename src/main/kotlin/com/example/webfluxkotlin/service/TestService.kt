package com.example.webfluxkotlin.service

import kotlinx.coroutines.withTimeout
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

@Service
class TestService(
    private val webClient: WebClient
) {

    suspend fun request(): String {
        val body = webClient.get().uri("https://hectorstatic.baidu.com/cd37ed75a9387c5b.js").awaitExchange {
            it.awaitBody(String::class)
        }

        return body
    }

}
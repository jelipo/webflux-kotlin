package com.example.webfluxkotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
@ConfigurationProperties("test")
class SpringConfig {

    @Bean
    fun webClient(): WebClient {
        val builder = WebClient.builder().build()
        return builder
    }

}
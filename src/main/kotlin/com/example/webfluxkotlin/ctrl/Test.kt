package com.example.webfluxkotlin.ctrl

import com.example.webfluxkotlin.service.TestService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author jelipo
 * @date 2021/3/12 17:42
 */
@RestController
@RequestMapping("/")
class Test(
    private val testService: TestService
) {

    @GetMapping("test")
    suspend fun test(): String {
        //println("Current thread name: " + Thread.currentThread().name)
        val request = testService.request()
        return request
    }
}
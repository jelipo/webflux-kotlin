package com.example.webfluxkotlin.ctrl

import com.example.webfluxkotlin.service.TestService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
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
        val async = GlobalScope.async {
            testService.request()
        }
        return async.await()
    }
}
package com.example.commerce.repository

import com.fasterxml.jackson.core.JsonProcessingException
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.time.Duration

@Repository
class AccountRedisRepository(
    private val redisTemplate: RedisTemplate<String, Int>
) {
    val TTL = Duration.ofDays(1)

    fun setLoginFailCount(email: String): Int {
        var failedCount = (redisTemplate.opsForValue().get(email) ?: 0) + 1
        redisTemplate.opsForValue().set(email, failedCount, TTL)
        return failedCount
    }
}
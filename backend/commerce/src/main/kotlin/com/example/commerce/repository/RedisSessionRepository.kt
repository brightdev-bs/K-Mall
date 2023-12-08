package com.example.commerce.repository

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.time.Duration
import java.util.concurrent.TimeUnit

@Repository
class RedisSessionRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    private val SESSION_PREFIX = "kmall:sessions"

    fun setSession(sessionId: String) {
        redisTemplate.opsForSet().add(SESSION_PREFIX, sessionId)
        redisTemplate.expire(SESSION_PREFIX, 3, TimeUnit.DAYS)
    }

    fun isExistedSession(sessionId: String): Boolean {
        return redisTemplate.opsForSet().isMember(SESSION_PREFIX, sessionId) != null
    }
}
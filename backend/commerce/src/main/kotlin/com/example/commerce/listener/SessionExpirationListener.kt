package com.example.commerce.listener

import com.example.commerce.global.logger.logger
import com.example.commerce.repository.RedisSessionRepository
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.stereotype.Component

@Component
class SessionExpirationListener(
    listener: RedisMessageListenerContainer,
    private val sessionRepository: RedisSessionRepository,
): KeyExpirationEventMessageListener(listener) {

    val log = logger()

    override fun onMessage(message: Message, pattern: ByteArray?) {
        log.info("SessionExpirationListener.onMessage")
        log.info("message = ${message}")
        val sessionMessage = message.toString()
        val sessionId = sessionMessage.substring(
            sessionMessage.lastIndexOf(":") + 1
        )
        log.info("delete sessionId = ${sessionId}")
        sessionRepository.deleteSession(sessionId)
        super.onMessage(message, pattern)
    }

}
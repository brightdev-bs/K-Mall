package com.example.commerce.repository

import com.example.commerce.global.logger.logger
import com.example.commerce.payload.basket.BasketItemDTO
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class RedisSessionRepository(
    private val redisTemplate: RedisTemplate<Any, Any>,
) {

    val log = logger()
    private val BASKET_EXCEPTION_MSG = "이미 장바구니에 존재하는 아이템입니다."
    private val SESSION_PREFIX = "kmall:sessions:"
    private val BASKET_PREFIX = "BASKET:"

    /**
     * sessionId는 인코딩해서 넘겨주어야 한다.
     * Spring Session의 DefaultCookiSerialize 정책으로 Base64로 인코딩 된 값이 클라이언트에게 리턴되기 때문
     */
    fun isExistedSession(sessionId: String): Boolean {
        val decode = String(Base64.getDecoder().decode(sessionId))
        val hasKey = redisTemplate.opsForHash<String, String>().hasKey(SESSION_PREFIX + decode, "creationTime")
        return hasKey
    }

    fun addBasketItem(sessionId: String, basketItemDTO: BasketItemDTO) {
        val key = BASKET_PREFIX + sessionId

        val productId = basketItemDTO.productId.toString()

        val hasKey = redisTemplate.opsForHash<String, Any>().hasKey(key, productId)
        if (hasKey) {
            log.debug(BASKET_EXCEPTION_MSG)
            throw DuplicateKeyException(BASKET_EXCEPTION_MSG)
        } else {
            redisTemplate.opsForHash<String, Any>().put(key, productId, 0)
        }
    }

    fun deleteSession(sessionId: String) {

        val key = BASKET_PREFIX + sessionId
        // redis hash key 삭제
        redisTemplate.delete(key)

    }
}
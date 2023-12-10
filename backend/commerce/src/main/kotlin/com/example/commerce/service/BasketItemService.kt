package com.example.commerce.service

import com.example.commerce.global.exception.ProductException
import com.example.commerce.global.logger.logger
import com.example.commerce.payload.basket.BasketItemDTO
import com.example.commerce.payload.basket.BasketItemRequest
import com.example.commerce.repository.RedisSessionRepository
import com.example.commerce.repository.product.ProductRepository
import jakarta.servlet.http.HttpServletRequest
import org.hibernate.SessionException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional(readOnly = true)
@Service
class BasketItemService(
    private val productRepository: ProductRepository,
    private val redisSessionRepository: RedisSessionRepository,
) {

    val log = logger()

    @Transactional
    fun addBasketItem(basketItemRequest: BasketItemRequest, httpServletRequest: HttpServletRequest): BasketItemDTO {
        val session = httpServletRequest.getSession(false)
        val sessionId = String(Base64.getEncoder().encode(session.id.toByteArray()))

        log.debug("sessionId = ${sessionId}")

        if (!redisSessionRepository.isExistedSession(sessionId)) throw SessionException("존재하지 않는 세션입니다.")

        val product = productRepository.findByIdOrNull(basketItemRequest.productId)
            ?: throw ProductException.NotFoundProductException()

        val basketItem = BasketItemDTO(
            productId = product.id!!,
        )

        redisSessionRepository.addBasketItem(session.id, basketItem)

        return basketItem

    }

}
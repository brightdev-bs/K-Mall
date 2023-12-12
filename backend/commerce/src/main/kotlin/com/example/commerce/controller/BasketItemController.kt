package com.example.commerce.controller

import com.example.commerce.global.response.ApiResponse
import com.example.commerce.payload.basket.BasketItemRequest
import com.example.commerce.service.BasketItemService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/basket-items")
@RestController
class BasketItemController(
    private val basketItemService: BasketItemService,
) {

    @PostMapping
    fun addBasketItem(@RequestBody basketItemRequest: BasketItemRequest, request: HttpServletRequest): ApiResponse {
        val response = basketItemService.addBasketItem(basketItemRequest, request)
        return ApiResponse.of(HttpStatus.CREATED, response)
    }
}
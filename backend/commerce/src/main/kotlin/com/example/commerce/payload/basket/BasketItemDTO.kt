package com.example.commerce.payload.basket

import java.io.Serializable

data class BasketItemDTO (
    val productId: Long = 0,
    val buyingNumber: Int? = 0
): Serializable {
}

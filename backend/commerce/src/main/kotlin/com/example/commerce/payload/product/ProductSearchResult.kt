package com.example.commerce.payload.product

import com.example.commerce.entity.Product

data class ProductSearchResult(
    val id: Long,
    val thumbnail: String,
    val productName: String,
    val description: String,
    val price: Int,
    val discountPrice: Int?,
) {
    companion object {
        fun from(product: Product): ProductSearchResult {
            return ProductSearchResult(
                id = product.id!!,
                thumbnail = product.thumbnailUrl,
                productName = product.productName,
                description = product.description,
                price = product.price,
                discountPrice = null,
            )
        }
    }
}
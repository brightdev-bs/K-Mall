package com.example.commerce.payload.product

import com.example.commerce.entity.Product

data class ProductDetail(
    val id: Long?,
    val thumbnail: String,
    val categoryName: String,
    val productName: String,
    val description: String,
    val body: String,
    val price: Int,
) {
    companion object {
        fun from(product: Product): ProductDetail {
            return ProductDetail(
                id = product.id,
                thumbnail = product.thumbnailUrl,
                categoryName = product.category.categoryName,
                productName = product.productName,
                description = product.description,
                body = product.body,
                price = product.price
            );
        }
    }
}



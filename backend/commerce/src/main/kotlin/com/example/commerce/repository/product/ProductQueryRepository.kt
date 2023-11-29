package com.example.commerce.repository.product

import com.example.commerce.entity.Product
import com.example.commerce.entity.QProduct.product
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductQueryRepository(
    private val queryFactory: JPAQueryFactory
) {
    fun findBySearchWord(searchWord: String): List<Product> {
        return queryFactory
            .selectFrom(product)
            .where(product.productName.contains(searchWord))
            .fetch()
    }
}
package com.example.commerce.service

import com.example.commerce.payload.product.ProductSearchResult
import com.example.commerce.repository.product.ProductCategoryRepository
import com.example.commerce.repository.product.ProductQueryRepository
import com.example.commerce.repository.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productQueryRepository: ProductQueryRepository,
    private val productCategoryRepository: ProductCategoryRepository
) {


    fun findProductsBySearch(keyword: String): List<ProductSearchResult> {
        val results = productQueryRepository.findBySearchWord(keyword)
        return results
            .map { result -> ProductSearchResult.from(result) }
            .toList();
    }

}
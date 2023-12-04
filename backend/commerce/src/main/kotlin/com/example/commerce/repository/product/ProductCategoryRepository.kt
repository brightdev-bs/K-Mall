package com.example.commerce.repository.product

import com.example.commerce.entity.ProductCategory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCategoryRepository: JpaRepository<ProductCategory, Long> {
    
    fun findByCategoryName(categoryName: String): ProductCategory?
}
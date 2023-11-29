package com.example.commerce.repository.product

import com.example.commerce.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {}
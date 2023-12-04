package com.example.commerce.controller

import com.example.commerce.global.response.ApiResponse
import com.example.commerce.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/products")
@RestController
class ProductController(
    private val productService: ProductService
) {
    @GetMapping
    fun searchProducts(keyword: String): ApiResponse {
        val result = productService.findProductsBySearch(keyword)
        return ApiResponse.of(HttpStatus.OK, result);
    }
}
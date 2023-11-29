package com.example.commerce.global.exception

open class ProductCategoryException(message: String): Exception(message) {

    class NotFoundProductCategoryException: ProductCategoryException("카테고리를 찾을 수 없습니다.")
}
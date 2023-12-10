package com.example.commerce.global.exception

open class ProductException(message: String): Exception(message){
    class NotFoundProductException: ProductException("상품을 찾을 수 없습니다.")
}
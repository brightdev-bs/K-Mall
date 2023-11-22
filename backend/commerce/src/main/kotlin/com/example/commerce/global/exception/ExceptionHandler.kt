package com.example.commerce.global.exception

import com.example.commerce.global.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    /**
     * javax.validation.Valid 또는 @Validated binding error가 발생할 경우
     */
    @ExceptionHandler(BindException::class)
    protected fun handleBindException(e: BindException): ApiResponse {
        return ApiResponse.of(HttpStatus.BAD_REQUEST, e.bindingResult)
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    protected fun handleHttpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): ApiResponse {
        return ApiResponse.of(HttpStatus.METHOD_NOT_ALLOWED, e.body)
    }


    /**
     * Account와 관련된 예외
     */
    @ExceptionHandler(AccountException::class)
    protected fun handleAccountException(e: AccountException): ApiResponse {
        return ApiResponse.of(HttpStatus.BAD_REQUEST, e.message)
    }
}
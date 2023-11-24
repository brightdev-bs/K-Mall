package com.example.commerce.global.exception

import com.example.commerce.global.response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    protected fun handleBindException(e: BindException): ResponseEntity<ApiResponse> {
        val errorResponse = ApiResponse.of(HttpStatus.BAD_REQUEST, e.bindingResult)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body<ApiResponse>(errorResponse)
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    protected fun handleHttpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): ResponseEntity<ApiResponse> {
        val errorResponse = ApiResponse.of(HttpStatus.METHOD_NOT_ALLOWED, e.body)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body<ApiResponse>(errorResponse)
    }


    /**
     * Account와 관련된 예외
     */
    @ExceptionHandler(AccountException::class)
    protected fun handleAccountException(e: AccountException): ResponseEntity<ApiResponse> {
        val errorResponse = ApiResponse.of(HttpStatus.BAD_REQUEST, e.message)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body<ApiResponse>(errorResponse)
    }

    /**
     * Email 관련 예외
     */
    @ExceptionHandler(EmailException::class)
    protected fun handleEmailException(e: EmailException): ResponseEntity<ApiResponse> {
        val errorResponse = ApiResponse.of(HttpStatus.BAD_REQUEST, e.message)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body<ApiResponse>(errorResponse)
    }

    /**
     * 나머지 예외
     */
    @ExceptionHandler(Exception::class)
    protected fun handleEmailException(e: Exception): ResponseEntity<ApiResponse> {
        val errorResponse = ApiResponse.of(HttpStatus.BAD_REQUEST, e.message)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body<ApiResponse>(errorResponse)
    }
}
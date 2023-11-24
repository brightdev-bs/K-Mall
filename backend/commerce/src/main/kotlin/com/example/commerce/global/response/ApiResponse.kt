package com.example.commerce.global.response

import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult

class ApiResponse private constructor(val statusCode: HttpStatus, val message: Any?) {

    companion object {

        fun of(statusCode: HttpStatus, response: Any?): ApiResponse {
            return ApiResponse(statusCode, response);
        }

        fun of(statusCode: HttpStatus, bindingResult: BindingResult): ApiResponse {
            return ApiResponse(statusCode, createErrorMessage(bindingResult))
        }

        private fun createErrorMessage(bindingResult: BindingResult): String {
            val sb = StringBuilder()
            var isFirst = true

            val fieldErrors = bindingResult.fieldErrors
            for (fieldError in fieldErrors) {
                if (!isFirst) {
                    sb.append(", ")
                } else {
                    isFirst = false
                }
                sb.append("[")
                sb.append(fieldError.field)
                sb.append("] ")
                sb.append(fieldError.defaultMessage)
            }

            return sb.toString()
        }
    }
}
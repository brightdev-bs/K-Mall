package com.example.commerce.global.exception

open class EmailException(message: String): Exception(message) {
    class NotFoundEmailLinkException: EmailException("유효하지 않은 이메일 링크입니다.")
}
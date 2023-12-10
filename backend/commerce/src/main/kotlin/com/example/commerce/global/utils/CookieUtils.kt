package com.example.commerce.global.utils

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger(String::class.java)!!

fun getSessionFromCookie(request: HttpServletRequest): String? {
    val cookies = request.cookies
    if (cookies != null) {
        for (cookie in cookies) {
            if (cookie.name.equals("SESSION")) {
                log.debug("session 찾음")
                return cookie.value;
            }
        }
    } else {
        log.info("No cookies")
        return null
    }
    return null
}
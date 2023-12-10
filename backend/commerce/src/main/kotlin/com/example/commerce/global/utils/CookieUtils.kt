package com.example.commerce.global.utils

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory

val log = LoggerFactory.getLogger(String::class.java)!!

fun getSessionFromCookie(request: HttpServletRequest): String? {
    val cookies = request.cookies
    if (cookies != null) {
        for (cookie in cookies) {
            if (cookie.name.equals("SESSION")) {
                log.debug("Cookie founded")
                return cookie.value;
            }
        }
    } else {
        log.debug("No cookies")
        return null
    }
    return null
}
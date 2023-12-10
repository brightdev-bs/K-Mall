package com.example.commerce.global.filter

import com.example.commerce.global.utils.getSessionFromCookie
import com.example.commerce.repository.RedisSessionRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

// Filter -> 요청, 응답 총 2번, OncePerRequestFilter -> 1번

@Component
class SessionFilter(
    private val redisSessionRepository: RedisSessionRepository,
): OncePerRequestFilter() {

    val log = logger

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        if (request.method == HttpMethod.OPTIONS.toString()) {
            log.debug("This is preflight")
        } else {
            val session = getSessionFromCookie(request)
            if (session == null) {
                val sessionId = request.getSession(true).id
            }
        }


        filterChain.doFilter(request, response)
    }
}
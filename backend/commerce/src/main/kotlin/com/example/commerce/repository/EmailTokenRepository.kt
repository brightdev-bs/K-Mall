package com.example.commerce.repository

import com.example.commerce.entity.EmailToken
import org.springframework.data.jpa.repository.JpaRepository

interface EmailTokenRepository: JpaRepository<EmailToken, Long> {

    fun findByLink(link: String): EmailToken?
}
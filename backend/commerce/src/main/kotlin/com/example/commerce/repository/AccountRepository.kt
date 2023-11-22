package com.example.commerce.repository

import com.example.commerce.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Customer?
    fun findByUsername(username: String): Customer?
}
package com.example.commerce.service

import com.example.commerce.entity.Customer
import com.example.commerce.global.exception.AccountException
import com.example.commerce.global.exception.AccountException.*
import com.example.commerce.payload.account.SignupForm
import com.example.commerce.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val emailService: EmailService,
) {

    fun sendEmail(email: String) {
        if(isDuplicated(email)) throw DuplicatedEmailException()
        emailService.sendEmail(email)
    }

    private fun isDuplicated(email: String): Boolean {
        return accountRepository.findByEmail(email) != null
    }

    fun signup(request: SignupForm): Customer {

        if (accountRepository.findByUsername(request.username) != null) throw DuplicatedUsernameException()

        val newCustomer = Customer(
            email = request.email,
            password = request.password,
            username = request.username
        )

        return accountRepository.save(newCustomer)
    }
}
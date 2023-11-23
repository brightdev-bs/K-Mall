package com.example.commerce.service

import com.example.commerce.entity.Customer
import com.example.commerce.global.exception.AccountException.*
import com.example.commerce.payload.account.AccountResponse
import com.example.commerce.payload.account.LoginForm
import com.example.commerce.payload.account.SignupForm
import com.example.commerce.repository.AccountRedisRepository
import com.example.commerce.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val accountRedisRepository: AccountRedisRepository,
    private val emailService: EmailService,
) {

    val MAX_TRY_COUNT = 5

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

    fun login(request: LoginForm): AccountResponse {

        val customer = accountRepository.findByEmail(request.email) ?: throw InvalidFormException()

        if (request.password != customer.password) {
            val loginFailCount = accountRedisRepository.setLoginFailCount(request.email)
            if (loginFailCount >= MAX_TRY_COUNT) {
                throw InvalidFormException("5번 실패하여 계정이 잠겼습니다. 본인 인증을 해주세요.")
            }
            throw InvalidFormException("5번 실패하면 계정이 잠깁니다. 틀린 횟수: ${loginFailCount}")
        }

        return AccountResponse(
            email = customer.email,
            username = customer.username,
            point = customer.point,
        )
    }
}
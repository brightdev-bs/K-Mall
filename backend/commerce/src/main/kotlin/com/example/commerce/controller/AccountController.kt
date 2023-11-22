package com.example.commerce.controller

import com.example.commerce.global.response.ApiResponse
import com.example.commerce.payload.account.SignupForm
import com.example.commerce.payload.email.EmailRequest
import com.example.commerce.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(private val accountService: AccountService) {

    @PostMapping("/email")
    fun sendEmail(@RequestBody request: EmailRequest): ApiResponse {
        accountService.sendEmail(request.email)
        return ApiResponse.of(HttpStatus.OK, "이메일 전송 완료")
    }

    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupForm): ApiResponse {
        accountService.signup(request);
        return ApiResponse.of(HttpStatus.CREATED, "회원가입이 완료되었습니다.")
    }

}
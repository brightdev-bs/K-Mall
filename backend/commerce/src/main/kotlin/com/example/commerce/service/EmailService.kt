package com.example.commerce.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EmailService(private val mailSender: JavaMailSender) {

    @Async
    fun sendEmail(email: String) {
        val mail = SimpleMailMessage()
        mail.setTo(email)
        mail.setSubject("K-Mall 이메일 확인.")
        mail.setText("이메일이 확인 되었습니다. 회원가입을 계속 해주세요.")
        try {
            mailSender.send(mail)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
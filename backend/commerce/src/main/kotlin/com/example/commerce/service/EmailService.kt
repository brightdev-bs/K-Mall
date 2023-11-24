package com.example.commerce.service

import com.example.commerce.entity.EmailToken
import com.example.commerce.global.exception.EmailException
import com.example.commerce.global.exception.EmailException.*
import com.example.commerce.repository.EmailTokenRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val mailSender: JavaMailSender,
    private val emailTokenRepository: EmailTokenRepository,
) {

    fun sendEmail(email: String) {
        val mail = SimpleMailMessage()
        mail.setTo(email)
        mail.setSubject("K-Mall 이메일 확인.")
        mail.setText("이메일이 확인 되었습니다. 회원가입을 계속 해주세요.")
        try {
            mailSender.send(mail)
        } catch (e: Exception) {
            throw EmailException(e.message!!)
        }
    }

    fun sendRestoreEmail(email: String, link: String) {
        val mail = SimpleMailMessage()
        mail.setTo(email)
        mail.setSubject("K-Mall 계정 복구 이메일")
        mail.setText("다음 링크를 클릭하여 계정을 복구해주세요. ${link}")
        try {
            mailSender.send(mail)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun findByLink(link: String): String {
        val emailToken = emailTokenRepository.findByLink(link) ?: throw NotFoundEmailLinkException()
        return emailToken.email
    }

    fun save(emailToken: EmailToken): EmailToken {
        return emailTokenRepository.save(emailToken)
    }
}
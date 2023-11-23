package com.example.commerce.payload.account

data class PasswordResetForm(
    val password: String,
    val link: String,
)

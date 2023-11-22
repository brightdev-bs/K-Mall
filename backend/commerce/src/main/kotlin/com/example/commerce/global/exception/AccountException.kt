package com.example.commerce.global.exception

open class AccountException(message: String): Exception(message) {

    class DuplicatedEmailException: AccountException("이미 사용하고 있는 이메일입니다.")

    class DuplicatedUsernameException: AccountException("이미 사용하고 있는 이름입니다.")
}
package com.example.commerce.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["email"]),
    UniqueConstraint(columnNames = ["username"]),
])
@Entity
class Customer(
    val email: String,
    val password: String,
    var username: String,
    var point: Int = 0,
    ) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
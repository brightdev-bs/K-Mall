package com.example.commerce.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class ProductCategory(
    @Column(unique = true, nullable = false)
    val categoryName: String,
    val description: String,
    @OneToMany(mappedBy = "category")
    val products: MutableList<Product>
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
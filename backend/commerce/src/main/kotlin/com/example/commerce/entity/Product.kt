package com.example.commerce.entity

import jakarta.persistence.*

@Entity
class Product(
    @ManyToOne
    @JoinColumn
    private var category: ProductCategory,
    @Column(nullable = false)
    var productName: String,

    @Column(columnDefinition = "TEXT")
    var description: String,
    @Column(nullable = false)
    var price: Int,

) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
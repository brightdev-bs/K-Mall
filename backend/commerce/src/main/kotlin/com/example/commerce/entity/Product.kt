package com.example.commerce.entity

import com.example.commerce.global.annotations.AllOpen
import jakarta.persistence.*

@AllOpen
@Entity
class Product(
    @ManyToOne
    @JoinColumn
    var category: ProductCategory,

    @Column(nullable = false)
    var productName: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    val thumbnailUrl: String,

    @Column(columnDefinition = "TEXT")
    var body: String,
    @Column(nullable = false)
    var price: Int,

    ) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
package com.example.commerce.entity

import jakarta.persistence.*
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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
package com.example.reactive.post.domain

import com.example.reactive.common.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Book(
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val contents: String,
    @Column(nullable = false)
    val author: String
): BaseEntity()
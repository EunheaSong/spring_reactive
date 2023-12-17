package com.example.reactive.post.domain

import com.example.reactive.common.BaseEntity
import javax.persistence.*

@Entity
class AudioBook(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book,
    @Column(nullable = false, length = 15)
    val registrantId: String,
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val contents: String,
): BaseEntity()
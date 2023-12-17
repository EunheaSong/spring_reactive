package com.example.reactive.post.infrastructure.repository

import com.example.reactive.post.domain.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, String> {
    fun findByIdAndIsDeletedFalse(id: String): Book?
}
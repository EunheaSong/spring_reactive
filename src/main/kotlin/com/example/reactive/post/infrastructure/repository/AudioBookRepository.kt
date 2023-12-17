package com.example.reactive.post.infrastructure.repository

import com.example.reactive.post.domain.AudioBook
import org.springframework.data.jpa.repository.JpaRepository

interface AudioBookRepository: JpaRepository<AudioBook, String> {
    fun findByIdAndIsDeletedFalse(id: String): AudioBook?
}
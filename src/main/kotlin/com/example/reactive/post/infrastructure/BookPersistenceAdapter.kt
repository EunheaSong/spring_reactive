package com.example.reactive.post.infrastructure

import com.example.reactive.common.NotFoundResourceException
import com.example.reactive.post.domain.Book
import com.example.reactive.post.infrastructure.repository.BookRepository
import org.springframework.stereotype.Component

@Component
class BookPersistenceAdapter(
    private val bookRepository: BookRepository
) {
    fun getBookById(id: String): Book {
        return bookRepository.findByIdAndIsDeletedFalse(id)
            ?: throw NotFoundResourceException("id 와 일치하는 도서를 찾을 수 없습니다.")
    }

}
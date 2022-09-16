package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServices(
    val bookRepository: BookRepository
) {
    fun create(book: BookModel) {
        bookRepository.save(book)
    }

}

package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.enum.BookStatus
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



    fun getMapping(name: String?): List<BookModel> {

        name?.let {
            return bookRepository.findByNameContaining(name)
        }
        return bookRepository.findAll().toList()
    }

    fun getMappingId(id: Int): BookModel {

        return bookRepository.findById(id).orElseThrow()
    }

    fun update(book: BookModel) {

        if (!bookRepository.existsById(book.id!!)){
            throw Exception()
        }

        bookRepository.save(book)

    }

    fun findActivities(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }


}

package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.enum.BookStatus
import com.mercadolivro.mercadolivro.enum.Erros
import com.mercadolivro.mercadolivro.exception.NotFoundException
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

        return bookRepository.findById(id).orElseThrow{ NotFoundException(Erros.ML001.message.format(id),Erros.ML001.code)}
    }

    fun update(book: BookModel) {

        if (!bookRepository.existsById(book.id!!)){
            throw NotFoundException(Erros.ML001.message.format(book.id),Erros.ML001.code)
        }

        bookRepository.save(book)

    }

    fun findActivities(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun delete(id: Int) {

        val book = getMappingId(id)
        book.status = BookStatus.DELETADO
       // if (!bookRepository.existsById(id)){
         //   throw Exception()
        //}


        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomersModel) {
        val books = bookRepository.findByCustomer(customer)

        for (book in books){
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(books)
    }

   /* fun findAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }*/


}

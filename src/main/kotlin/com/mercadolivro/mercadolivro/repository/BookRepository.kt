package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.enum.BookStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import org.springframework.data.repository.CrudRepository
import java.awt.print.Book


interface BookRepository:CrudRepository<BookModel,Int> {

    fun findByNameContaining(name: String): List<BookModel>
    fun findByStatus(ativo: BookStatus): List<BookModel>

}
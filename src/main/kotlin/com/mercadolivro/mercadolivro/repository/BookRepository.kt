package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.enum.BookStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.awt.print.Book
import java.awt.print.Pageable


interface BookRepository:CrudRepository<BookModel,Int> {

    fun findByNameContaining(name: String): List<BookModel>
    fun findByStatus(ativo: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomersModel): List<BookModel>

    //fun findAll(pageable:org.springframework.data.domain.Pageable):Page<BookModel>

}
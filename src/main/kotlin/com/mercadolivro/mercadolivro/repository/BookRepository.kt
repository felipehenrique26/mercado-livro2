package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import org.springframework.data.repository.CrudRepository


interface BookRepository:CrudRepository<BookModel,Int> {

}
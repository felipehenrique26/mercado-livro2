package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.extension.toBookModel
import com.mercadolivro.mercadolivro.request.PostBookRequest
import com.mercadolivro.mercadolivro.services.BookServices
import com.mercadolivro.mercadolivro.services.CustomersServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("book")
class BookController(
    val customerService: CustomersServices,
    val bookService: BookServices
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create (@RequestBody request : PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }
}
package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.extension.toBookModel
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.request.PostBookRequest
import com.mercadolivro.mercadolivro.request.PutBookRequest
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

    @GetMapping
    fun getMapping(@RequestParam name:String?):List<BookModel>{


       return  bookService.getMapping(name)
    }

    @GetMapping("/{id}")
    fun getMappingId(@PathVariable id:Int):BookModel{
        return bookService.getMappingId(id)
    }

    @GetMapping("/activities")
    fun getMappingActivity():List<BookModel>{
        return bookService.findActivities()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create (@RequestBody request : PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @PutMapping("{id}")
    fun update (@PathVariable id: Int, @RequestBody book: PutBookRequest){
        val bookSaved = bookService.getMappingId(id)
        return bookService.update(book.toBookModel(bookSaved))
    }
}
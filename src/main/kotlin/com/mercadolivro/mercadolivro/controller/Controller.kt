package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.extension.toCustomerModel
import com.mercadolivro.mercadolivro.model.Usuario
import com.mercadolivro.mercadolivro.request.PostRequestModel
import com.mercadolivro.mercadolivro.request.PutRequestModel
import com.mercadolivro.mercadolivro.services.CustomersServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class Controller(val customersService: CustomersServices) {

    val customers = mutableListOf<Usuario>()

    @GetMapping()
    fun getAll(@RequestParam name: String?): List<Usuario> {

        name?.let {
            return customers.filter { it.nome.contains(name,true) }
        }

        return customersService.getmapping()
    }

    @GetMapping("/{id}")
    fun getCustomers(@PathVariable(name = "id") id: String): Usuario {

        return customersService.getCustomers(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody usuario: PostRequestModel) {

        return customersService.create(usuario.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable(name = "id") id: String, @RequestBody usuario: PutRequestModel) {

        customersService.update(id, usuario)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
      customersService.delete(id)
    }


}
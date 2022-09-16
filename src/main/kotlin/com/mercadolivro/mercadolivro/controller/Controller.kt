package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.extension.toCustomerModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.request.PostRequestModel
import com.mercadolivro.mercadolivro.request.PutRequestModel
import com.mercadolivro.mercadolivro.services.CustomersServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class Controller(val customersService: CustomersServices) {

    val customers = mutableListOf<CustomersModel>()

    @GetMapping()
    fun getAll(@RequestParam nome: String?): List<CustomersModel> {

        return customersService.getmapping(nome)
    }

    @GetMapping("/{id}")
    fun getCustomers(@PathVariable(name = "id") id: Int): CustomersModel {

        return customersService.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody usuario: PostRequestModel) {

      customersService.create(usuario.toCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable(name = "id") id: Int, @RequestBody usuario: PutRequestModel) {

        customersService.update(usuario.toCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
      customersService.delete(id)
    }


}
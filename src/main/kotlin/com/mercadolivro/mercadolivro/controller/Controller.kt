package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.model.Usuario
import com.mercadolivro.mercadolivro.request.PostRequestModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class Controller {

    val customers = mutableListOf<Usuario>()

    @GetMapping("/teste")
    fun getmapping(): MutableList<Usuario> {
        return customers
    }

    @GetMapping("/teste/{codigo}")
    fun encontraUsuario(@PathVariable(name = "codigo") codigo: String): Usuario {
       /* var respostaCustomers = mutableListOf<Usuario>()
        if (customers.isNotEmpty()) {
            respostaCustomers = if (customers.get(0).id == codigo) {
                customers
            } else {
                respostaCustomers
            }
        }*/

        return customers.filter { it.id == codigo }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postMapping(@RequestBody usuario: PostRequestModel): PostRequestModel {


        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(Usuario(id, usuario.nome, usuario.idade))

        return usuario
    }

}
package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.model.Usuario
import com.mercadolivro.mercadolivro.request.PostRequestModel
import com.mercadolivro.mercadolivro.request.PutRequestModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class CustomersServices {

    val customers = mutableListOf<Usuario>()


    fun getmapping(): MutableList<Usuario> {
        return customers
    }

    fun getCustomers(id: String): Usuario {
        /* var respostaCustomers = mutableListOf<Usuario>()
         if (customers.isNotEmpty()) {
             respostaCustomers = if (customers.get(0).id == codigo) {
                 customers
             } else {
                 respostaCustomers
             }
         }*/

        return customers.filter { it.id == id }.first()
    }

    fun create(usuario: Usuario) {


        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(usuario)

    }

    fun update( id: String, usuario: PutRequestModel) {


        customers.filter { it.id == id }.first().let {
            it.nome = usuario.nome
            it.email = usuario.email

        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}
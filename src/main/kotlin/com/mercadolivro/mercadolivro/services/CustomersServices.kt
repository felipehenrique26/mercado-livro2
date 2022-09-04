package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.model.CustomersModel
import org.springframework.stereotype.Service

@Service
class CustomersServices {

    val customers = mutableListOf<CustomersModel>()


    fun getmapping(): MutableList<CustomersModel> {
        return customers
    }

    fun getCustomers(id: String): CustomersModel {
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

    fun create(usuario: CustomersModel) {


        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        }.toString()

        usuario.id = id

        customers.add(usuario)

    }

    fun update(usuario: CustomersModel) {


        customers.filter { it.id == usuario.id }.first().let {
            it.nome = usuario.nome
            it.email = usuario.email

        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}
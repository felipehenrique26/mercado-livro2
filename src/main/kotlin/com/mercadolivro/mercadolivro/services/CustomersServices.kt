package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.repository.CustomersRepository
import org.springframework.stereotype.Service

@Service
class CustomersServices(val customersRepository: CustomersRepository) {

    //val customers = mutableListOf<CustomersModel>()


    fun getmapping(nome:String?): List<CustomersModel> {

       nome?.let {
            return customersRepository.findByNomeContaining(it)
        }

        return customersRepository.findAll().toList()
    }

    fun getById(id: Int): CustomersModel {

        return customersRepository.findById(id).orElseThrow()
    }

    fun create(usuario: CustomersModel) {

        customersRepository.save(usuario)

    }

    fun update(usuario: CustomersModel) {

        if (!customersRepository.existsById(usuario.id!!)){
            throw Exception()
        }

        customersRepository.save(usuario)

       // customers.filter { it.id == usuario.id }.first().let {
         //   it.nome = usuario.nome
           // it.email = usuario.email

        //}
    }

    fun delete(id: Int) {

        if (!customersRepository.existsById(id!!)){
            throw Exception()
        }
        //customers.removeIf { it.id == id }

        customersRepository.deleteById(id)
    }
}
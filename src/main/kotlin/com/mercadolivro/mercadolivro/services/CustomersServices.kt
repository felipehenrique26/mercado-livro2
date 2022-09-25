package com.mercadolivro.mercadolivro.services

import com.mercadolivro.mercadolivro.enum.CustomerStatus
import com.mercadolivro.mercadolivro.enum.Erros
import com.mercadolivro.mercadolivro.exception.NotFoundException
import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.repository.CustomersRepository
import org.springframework.stereotype.Service

@Service
class CustomersServices(val customersRepository: CustomersRepository,
val bookServices: BookServices) {

    //val customers = mutableListOf<CustomersModel>()


    fun getmapping(nome:String?): List<CustomersModel> {

       nome?.let {
            return customersRepository.findByNomeContaining(it)
        }

        return customersRepository.findAll().toList()
    }

    fun getById(id: Int): CustomersModel {

        return customersRepository.findById(id).orElseThrow{NotFoundException(Erros.ML101.message.format(id),Erros.ML101.code)}
    }

    fun create(usuario: CustomersModel) {

        customersRepository.save(usuario)

    }

    fun update(usuario: CustomersModel) {

        if (!customersRepository.existsById(usuario.id!!)){
            throw NotFoundException(Erros.ML101.message.format(usuario.id),Erros.ML101.code)
        }

        customersRepository.save(usuario)

       // customers.filter { it.id == usuario.id }.first().let {
         //   it.nome = usuario.nome
           // it.email = usuario.email

        //}
    }

    fun delete(id: Int) {

       val customer = getById(id)
        bookServices.deleteByCustomer(customer)
        //customers.removeIf { it.id == id }
        customer.status = CustomerStatus.INATIVO
        customersRepository.save(customer)
    }
}
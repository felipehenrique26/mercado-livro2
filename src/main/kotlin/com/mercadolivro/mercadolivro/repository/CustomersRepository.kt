package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.CustomersModel
import org.springframework.data.repository.CrudRepository


interface CustomersRepository:CrudRepository<CustomersModel,Int> {

    fun findByNomeContaining(nome:String):List<CustomersModel>
}
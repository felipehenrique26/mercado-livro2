package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.request.PostRequestModel
import com.mercadolivro.mercadolivro.request.PutRequestModel


fun PostRequestModel.toCustomerModel(): CustomersModel {

    return CustomersModel(nome = this.nome, email = this.email)
}

fun PutRequestModel.toCustomerModel(id:String): CustomersModel {

    return CustomersModel(id = id, nome = this.nome, email = this.email)
}
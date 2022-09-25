package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.enum.BookStatus
import com.mercadolivro.mercadolivro.enum.CustomerStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomersModel
import com.mercadolivro.mercadolivro.request.PostBookRequest
import com.mercadolivro.mercadolivro.request.PostRequestModel
import com.mercadolivro.mercadolivro.request.PutBookRequest
import com.mercadolivro.mercadolivro.request.PutRequestModel


fun PostRequestModel.toCustomerModel(): CustomersModel {

    return CustomersModel(nome = this.nome, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutRequestModel.toCustomerModel(previousCustomer:CustomersModel): CustomersModel {

    return CustomersModel(id = previousCustomer.id, nome = this.nome, email = this.email, status = previousCustomer.status)
}

fun PostBookRequest.toBookModel(customer:CustomersModel):BookModel {
    return BookModel(
        name = this.name, price = this.price, status = BookStatus.ATIVO, customer = customer
    )
}

fun PutBookRequest.toBookModel(previousBook: BookModel): BookModel{
    return BookModel(name = this.name,price=this.price,status=previousBook.status, customer = previousBook.customer)
}
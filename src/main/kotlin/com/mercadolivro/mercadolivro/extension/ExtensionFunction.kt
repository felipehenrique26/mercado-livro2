package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.model.Usuario
import com.mercadolivro.mercadolivro.request.PostRequestModel


fun PostRequestModel.toCustomerModel(): Usuario {

    return Usuario(nome = this.nome, email = this.email)
}
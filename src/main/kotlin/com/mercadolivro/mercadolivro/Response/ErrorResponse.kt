package com.mercadolivro.mercadolivro.Response

data class ErrorResponse(
    var codeHttp: Int,
    var message : String,
    var erroInterno: String,
    var erros: List<FieldErroResponse>?
) {
}
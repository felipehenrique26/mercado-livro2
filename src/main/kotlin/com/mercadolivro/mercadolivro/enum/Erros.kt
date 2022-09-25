package com.mercadolivro.mercadolivro.enum

enum class Erros(val code: String, val message :String) {
    ML001("ML-001","Book %s not exists"),
    ML102("ML-102","Canot update with status %s"),
    ML101("ML-101","Customer %s not exists")

}
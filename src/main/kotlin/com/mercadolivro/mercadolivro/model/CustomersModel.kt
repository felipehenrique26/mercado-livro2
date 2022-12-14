package com.mercadolivro.mercadolivro.model

import com.mercadolivro.mercadolivro.enum.CustomerStatus
import javax.persistence.*
import kotlin.properties.Delegates

@Entity(name = "customer")
class CustomersModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? =null,

    @Column(name = "nome", nullable = true)
    var nome: String = "",

    @Column(name = "email", nullable = true , unique = true)
    var email: String = "",

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status : CustomerStatus
){

}

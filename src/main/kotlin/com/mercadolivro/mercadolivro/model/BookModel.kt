package com.mercadolivro.mercadolivro.model

import com.mercadolivro.mercadolivro.enum.BookStatus
import com.mercadolivro.mercadolivro.enum.Erros
import com.mercadolivro.mercadolivro.exception.BadRequestException
import java.math.BigDecimal
import javax.persistence.*


@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? =null,

    @Column(name = "name")
    var name: String = "",

    @Column(name = "price")
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer:CustomersModel ?= null
    ){

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: BookStatus?=null
        set(value){
            if (field == BookStatus.CANCELADO || field == BookStatus.DELETADO) {
                throw BadRequestException(Erros.ML102.message.format(field), Erros.ML102.code)
            }
            field = value
        }

    constructor(id: Int? = null,
                name: String,
                price: BigDecimal,
                status: BookStatus?,
                customer: CustomersModel?=null):this(id, name, price, customer){
                this.status = status
                }



}

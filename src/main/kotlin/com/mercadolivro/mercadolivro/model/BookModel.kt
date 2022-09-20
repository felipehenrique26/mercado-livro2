package com.mercadolivro.mercadolivro.model

import com.mercadolivro.mercadolivro.enum.BookStatus
import java.math.BigDecimal
import javax.persistence.*
import kotlin.properties.Delegates

@Entity(name = "book")
class BookModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? =null,

    @Column(name = "name")
    var name: String = "",

    @Column(name = "price")
    var price: BigDecimal,

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    var status: BookStatus?,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer:CustomersModel ?= null
    )
{

}

package com.mercadolivro.mercadolivro.request

import java.math.BigDecimal

class PutBookRequest(
    var name:String,
    var price: BigDecimal,
    var id: Int
) {

}

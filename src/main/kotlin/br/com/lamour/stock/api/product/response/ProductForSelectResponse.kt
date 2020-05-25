package br.com.lamour.stock.api.product.response

import java.math.BigInteger

data class ProductForSelectResponse(
    val id: BigInteger,
    val name: String
)
package br.com.lamour.stock.api.order.request

import org.jetbrains.annotations.NotNull
import java.math.BigInteger

data class OrderRequest(
    @field:NotNull
    val clientId: BigInteger,

    @field:NotNull
    val productItems: List<ProductItemRequest>
)

data class ProductItemRequest(
    @field:NotNull
    val id: BigInteger,

    @field:NotNull
    val quantity: Int
)
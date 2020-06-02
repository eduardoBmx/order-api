package br.com.lamour.stock.api.order.response

import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.product.response.ProductResponse
import java.math.BigDecimal
import java.math.BigInteger

data class OrderResponse(
    val id: BigInteger,
    val client: ClientResponse,
    val items: List<ProductItemsResponse>,
    val total: BigDecimal
)

data class ProductItemsResponse (

    val id: BigInteger,

    val quantity: Int,

    val product: ProductResponse,

    val total: BigDecimal
)
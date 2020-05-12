package br.com.lamour.stock.api.order.response

import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.product.response.ProductResponse
import java.math.BigInteger

data class OrderResponse(
    val id: BigInteger,
    val client: ClientResponse,
    val items: List<ProductItemsResponse>
)

data class ProductItemsResponse (

    val quantity: Int,

    val product: ProductResponse
)
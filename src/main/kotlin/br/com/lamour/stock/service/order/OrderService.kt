package br.com.lamour.stock.service.order

import br.com.lamour.stock.api.order.request.OrderRequest
import br.com.lamour.stock.api.order.response.OrderResponse
import br.com.lamour.stock.api.order.response.PaginationOrderResponse
import java.math.BigInteger

interface OrderService {

    fun createOrder(
        orderRequest: OrderRequest
    ): OrderResponse

    fun deleteOrder(
        orderId: BigInteger
    )

    fun editOrder(
        orderId: BigInteger,
        orderRequest: OrderRequest
    ): OrderResponse

    fun getAllOrders(
        page: Int,
        size: Int
    ): PaginationOrderResponse


}
package br.com.lamour.stock.controller.order

import br.com.lamour.stock.api.order.OrderApi
import br.com.lamour.stock.api.order.request.OrderRequest
import br.com.lamour.stock.api.order.response.OrderResponse
import br.com.lamour.stock.api.order.response.PaginationOrderResponse
import br.com.lamour.stock.service.order.OrderService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigInteger
import javax.validation.Valid

@Controller
class OrderController(
    private val orderService: OrderService
): OrderApi {

    override fun createOrder(
        @Valid @RequestBody orderRequest: OrderRequest
    ): OrderResponse = orderService.createOrder(orderRequest)

    override fun listAllOrders(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationOrderResponse = orderService.getAllOrders(page, size)

    override fun editProduct(
        @PathVariable("orderId") orderId: BigInteger,
        @Valid @RequestBody orderRequest: OrderRequest
    ): OrderResponse = orderService.editOrder(orderId, orderRequest)

    override fun deleteProduct(
        @PathVariable("orderId") orderId: BigInteger
    ) = orderService.deleteOrder(orderId)

}
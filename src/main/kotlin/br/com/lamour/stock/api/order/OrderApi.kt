package br.com.lamour.stock.api.order

import br.com.lamour.stock.api.order.request.OrderRequest
import br.com.lamour.stock.api.order.response.OrderResponse
import br.com.lamour.stock.api.order.response.PaginationOrderResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.math.BigInteger
import javax.validation.Valid

@RequestMapping("/order")
@CrossOrigin
interface OrderApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createOrder(
        @Valid @RequestBody orderRequest: OrderRequest
    ): OrderResponse

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun listAllOrders(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationOrderResponse

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun editProduct(
        @PathVariable("orderId") orderId: BigInteger,
        @Valid @RequestBody orderRequest: OrderRequest
    ): OrderResponse

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun deleteProduct(
        @PathVariable("orderId") orderId: BigInteger
    )

}
package br.com.lamour.stock.service.order

import br.com.lamour.stock.api.order.request.OrderRequest
import br.com.lamour.stock.api.order.response.OrderResponse
import br.com.lamour.stock.api.order.response.PaginationOrderResponse
import br.com.lamour.stock.api.order.response.ProductItemsResponse
import br.com.lamour.stock.repository.entity.Item
import br.com.lamour.stock.repository.entity.ProductOrder
import br.com.lamour.stock.repository.entity.Product
import br.com.lamour.stock.service.client.toResponse
import br.com.lamour.stock.service.product.toResponse
import org.springframework.data.domain.Page
import java.math.BigInteger

fun OrderRequest.toEntityItems(productOrder: ProductOrder, products: List<Product>): List<Item> {
    return this.productItems.map { item ->
        Item(
            productOrder = productOrder,
            product = products.first { it.id == item.id },
            quantity = item.quantity
        )
    }
}

fun ProductOrder.toResponse(items: List<Item>): OrderResponse = OrderResponse(
    id = this.id,
    client = this.client.toResponse(),
    items = items.map {
        ProductItemsResponse(
            id = it.id!!,
            quantity = it.quantity,
            product = it.product.toResponse()
    ) }
)

fun Page<ProductOrder>.toPaginationResponse(items: List<Item>): PaginationOrderResponse = PaginationOrderResponse(
    content = this.content.map { content -> content.toResponse(items.filter { it.productOrder.id == content.id }) },
    number = this.number,
    totalElements = this.totalElements.toInt(),
    totalPages = this.totalPages
)
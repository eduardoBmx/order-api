package br.com.lamour.stock.service.order

import br.com.lamour.stock.api.order.request.OrderRequest
import br.com.lamour.stock.api.order.response.OrderResponse
import br.com.lamour.stock.api.order.response.PaginationOrderResponse
import br.com.lamour.stock.api.utils.exception.NotFoundException
import br.com.lamour.stock.repository.entity.Client
import br.com.lamour.stock.repository.entity.Item
import br.com.lamour.stock.repository.entity.ProductOrder
import br.com.lamour.stock.repository.entity.Product
import br.com.lamour.stock.repository.repository.client.ClientRepository
import br.com.lamour.stock.repository.repository.item.ItemRepository
import br.com.lamour.stock.repository.repository.order.OrderRepository
import br.com.lamour.stock.repository.repository.product.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository,
    private val clientRepository: ClientRepository,
    private val productRepository: ProductRepository
) : OrderService {
    override fun createOrder(orderRequest: OrderRequest): OrderResponse {
        verifyToService(orderRequest)

        val order = orderRepository.save(
            ProductOrder(client = getClient(orderRequest.clientId))
        )

        itemRepository.saveAll(orderRequest.toEntityItems(
            order,
            getProducts(orderRequest.productItems.map { it.id })
        ))

        return order.toResponse(getItemsByOrderId(listOf(order)))
    }

    override fun deleteOrder(orderId: BigInteger) {
        val order = getOrder(orderId)

        orderRepository.delete(order)
    }

    override fun editOrder(orderId: BigInteger, orderRequest: OrderRequest): OrderResponse {
        verifyToService(orderRequest)
        val products = getProducts(orderRequest.productItems.map { it.id })

        val order = getOrder(orderId)

        itemRepository.deleteAll(getItemsByOrderId(listOf(order)))
        orderRepository.delete(order)

        return createOrder(orderRequest)
    }

    override fun getAllOrders(page: Int, size: Int): PaginationOrderResponse {
        val orders = orderRepository.findAll(PageRequest.of(page - 1, size))

        return orders.toPaginationResponse(getItemsByOrderId(orders.content.map { it }))
    }

    private fun getItemsByOrderId(productOrders: List<ProductOrder>): List<Item>{
        return itemRepository.findAllByProductOrderIn(productOrders)
    }

    private fun getOrder(orderId: BigInteger): ProductOrder {
        return orderRepository.findByIdOrNull(orderId) ?: throw
        NotFoundException("Order not found!")
    }

    private fun getClient(clientId: BigInteger): Client {
        return clientRepository.findByIdOrNull(clientId) ?: throw
        NotFoundException("Client not found!")
    }

    private fun getProducts(productsIds: List<BigInteger>): List<Product> {
        return productRepository.findAllByIdIn(productsIds)
    }

    private fun verifyToService(orderRequest: OrderRequest) {

        orderRequest.productItems.map {
            if (!productRepository.existsById(it.id)) {
                throw NotFoundException("Product not found!")
            }
        }
    }
}
package br.com.lamour.stock.service.product

import br.com.lamour.stock.api.product.request.ProductRequest
import br.com.lamour.stock.api.product.response.PaginationProduct
import br.com.lamour.stock.api.product.response.ProductForSelectResponse
import br.com.lamour.stock.api.product.response.ProductResponse
import br.com.lamour.stock.repository.entity.Product
import org.springframework.data.domain.Page
import java.math.BigInteger

fun ProductRequest.toEntity(): Product =
    Product(
        id = BigInteger.ZERO,
        price = this.price!!,
        name = this.name!!,
        weightType = this.weightType!!
    )

fun Product.toResponse(): ProductResponse = ProductResponse(
    id = this.id,
    weightType = this.weightType,
    name = this.name,
    price = this.price
)

fun Page<Product>.toPaginationProduct(): PaginationProduct = PaginationProduct(
    content = this.content.map { it.toResponse() },
    totalPages = this.totalPages,
    number = this.number,
    totalElements = this.totalElements.toInt()
)

fun Product.toSelectResponse() = ProductForSelectResponse(
    id = this.id,
    name = this.name
)
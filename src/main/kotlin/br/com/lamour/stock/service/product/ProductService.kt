package br.com.lamour.stock.service.product

import br.com.lamour.stock.api.product.request.ProductRequest
import br.com.lamour.stock.api.product.response.PaginationProduct
import br.com.lamour.stock.api.product.response.ProductResponse
import java.math.BigInteger

interface ProductService {

    fun createProduct(
        productRequest: ProductRequest
    ): ProductResponse

    fun listAllProducts(
        page: Int,
        size: Int
    ): PaginationProduct

    fun deleteProduct(
        productId: BigInteger
    )

    fun editProduct(
        productId: BigInteger,
        productRequest: ProductRequest
    ): ProductResponse
}
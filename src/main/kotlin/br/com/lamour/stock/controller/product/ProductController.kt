package br.com.lamour.stock.controller.product

import br.com.lamour.stock.api.product.ProductApi
import br.com.lamour.stock.api.product.request.ProductRequest
import br.com.lamour.stock.api.product.response.PaginationProduct
import br.com.lamour.stock.api.product.response.ProductResponse
import br.com.lamour.stock.service.product.ProductService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigInteger
import javax.validation.Valid

@Controller
class ProductController(
    private val productService: ProductService
): ProductApi {

    override fun createProduct(
        @Valid @RequestBody productRequest: ProductRequest
    ): ProductResponse = productService.createProduct(productRequest)

    override fun listAllProducts(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationProduct = productService.listAllProducts(page, size)

    override fun editProduct(
        @PathVariable("productId") productId: BigInteger,
        @Valid @RequestBody productRequest: ProductRequest
    ): ProductResponse = productService.editProduct(productId, productRequest)

    override fun deleteProduct(
        @PathVariable("productId") productId: BigInteger
    ) = productService.deleteProduct(productId)
}
package br.com.lamour.stock.api.product

import br.com.lamour.stock.api.product.request.ProductRequest
import br.com.lamour.stock.api.product.response.PaginationProduct
import br.com.lamour.stock.api.product.response.ProductResponse
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

@RequestMapping("/product")
@CrossOrigin
interface ProductApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createProduct(
        @Valid @RequestBody productRequest: ProductRequest
    ): ProductResponse

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun listAllProducts(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationProduct

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun editProduct(
        @PathVariable("productId") productId: BigInteger,
        @Valid @RequestBody productRequest: ProductRequest
    ): ProductResponse

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    fun deleteProduct(
        @PathVariable("productId") productId: BigInteger
    )

}
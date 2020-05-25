package br.com.lamour.stock.service.product

import br.com.lamour.stock.api.product.request.ProductRequest
import br.com.lamour.stock.api.product.response.PaginationProduct
import br.com.lamour.stock.api.product.response.ProductForSelectResponse
import br.com.lamour.stock.api.product.response.ProductResponse
import br.com.lamour.stock.api.utils.exception.NotFoundException
import br.com.lamour.stock.repository.entity.Product
import br.com.lamour.stock.repository.repository.product.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun createProduct(
        productRequest: ProductRequest
    ): ProductResponse = productRepository.save(productRequest.toEntity()).toResponse()

    override fun listAllProducts(
        page: Int,
        size: Int
    ): PaginationProduct = productRepository.findAll(PageRequest.of(page -1, size, Sort.by(Sort.Direction.ASC,"id"))).toPaginationProduct()

    override fun deleteProduct(productId: BigInteger) {
        val product = getProductById(productId)

        productRepository.delete(product)
    }

    override fun editProduct(productId: BigInteger, productRequest: ProductRequest): ProductResponse {
        val product = getProductById(productId)

        return productRepository.save(product.copy(
            name = productRequest.name!!,
            price = productRequest.price!!,
            weightType = productRequest.weightType!!
        )).toResponse()
    }

    override fun getForSelect(): List<ProductForSelectResponse> {
        return productRepository.findAll().map { it.toSelectResponse() }
    }

    private fun getProductById(productId: BigInteger): Product {
        return productRepository.findByIdOrNull(productId)?: throw
        NotFoundException("Produto $productId não encontrado!")
    }

}
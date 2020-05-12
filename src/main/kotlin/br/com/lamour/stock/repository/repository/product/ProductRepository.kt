package br.com.lamour.stock.repository.repository.product

import br.com.lamour.stock.repository.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ProductRepository: JpaRepository<Product, BigInteger> {
    fun findAllByIdIn(productsIds: List<BigInteger>): List<Product>
}
package br.com.lamour.stock.repository.repository.order

import br.com.lamour.stock.repository.entity.ProductOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface OrderRepository: JpaRepository<ProductOrder, BigInteger> {
}
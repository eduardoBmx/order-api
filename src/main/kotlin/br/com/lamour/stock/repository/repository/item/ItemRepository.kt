package br.com.lamour.stock.repository.repository.item

import br.com.lamour.stock.repository.entity.Item
import br.com.lamour.stock.repository.entity.ProductOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ItemRepository: JpaRepository<Item, BigInteger> {
    fun findAllByProductOrderIn(productOrders: List<ProductOrder>): List<Item>

}
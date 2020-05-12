package br.com.lamour.stock.repository.entity

import br.com.lamour.stock.enum.product.WeightType
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigDecimal
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
data class Product (

    @Id
    @GenericGenerator(
        name = "product_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "product_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    val id: BigInteger = BigInteger.ZERO,

    @NotNull
    val name: String,

    @NotNull
    val price: BigDecimal,

    @NotNull
    @Enumerated(EnumType.STRING)
    val weightType: WeightType
) {
    @OneToMany(mappedBy = "product")
    val orders: MutableSet<Item> = HashSet()
}
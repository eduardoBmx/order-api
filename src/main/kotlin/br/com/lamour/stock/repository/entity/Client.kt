package br.com.lamour.stock.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
data class Client(
    @Id
    @GenericGenerator(
        name = "client_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "client_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    val id: BigInteger = BigInteger.ZERO,

    @NotNull
    val name: String,

    val phoneNumber: String? = null,

    val email: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    val address: Address
){
    @OneToMany(mappedBy = "client")
    val productOrders: MutableSet<ProductOrder> = HashSet()
}
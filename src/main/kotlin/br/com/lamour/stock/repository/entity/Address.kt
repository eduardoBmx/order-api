package br.com.lamour.stock.repository.entity

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class Address(
    @Id
    @GenericGenerator(
        name = "address_id_seq",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = [
            Parameter(name = "sequence_name", value = "address_id_seq"),
            Parameter(name = "initial_value", value = "1"),
            Parameter(name = "increment_size", value = "1")
        ]
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    val id: BigInteger = BigInteger.ONE,

    val street: String,

    val district: String,

    val city: String,

    val state: String,

    val number: String,

    val cep: String,

    val complement: String? = null

    )
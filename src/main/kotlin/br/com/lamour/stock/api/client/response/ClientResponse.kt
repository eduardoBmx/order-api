package br.com.lamour.stock.api.client.response

import java.math.BigInteger

data class ClientResponse(
    val id: BigInteger? = null,

    val name: String? = null,

    val phoneNumber: String? = null,

    val email: String? = null,

    val address: AddressResponse? = null
)

data class AddressResponse(
    val id: BigInteger? = null,

    val street: String? = null,

    val district: String? = null,

    val city: String? = null,

    val state: String? = null,

    val number: String? = null,

    val cep: String? = null,

    val complement: String? = null
)
package br.com.lamour.stock.api.client.request

import javax.validation.constraints.NotNull

data class ClientRequest(
    @field:NotNull
    val name: String? = null,

    @field:NotNull
    val phoneNumber: String? = null,

    val email: String? = null,

    val address: AddressRequest? = null
)

data class AddressRequest(
    @field:NotNull
    val street: String? = null,

    @field:NotNull
    val district: String? = null,

    @field:NotNull
    val city: String? = null,

    @field:NotNull
    val state: String? = null,

    @field:NotNull
    val number: String? = null,

    @field:NotNull
    val cep: String? = null,

    val complement: String? = null
)
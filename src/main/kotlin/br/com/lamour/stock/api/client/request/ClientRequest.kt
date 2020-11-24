package br.com.lamour.stock.api.client.request

import javax.validation.constraints.NotNull

data class ClientRequest(
    @field:NotNull
    val name: String,

    @field:NotNull
    val phoneNumber: String,

    val email: String,

    val address: AddressRequest
)

data class AddressRequest(
    @field:NotNull
    val street: String,

    @field:NotNull
    val district: String,

    @field:NotNull
    val city: String,

    @field:NotNull
    val state: String,

    @field:NotNull
    val number: String,

    @field:NotNull
    val cep: String,

    val complement: String
)
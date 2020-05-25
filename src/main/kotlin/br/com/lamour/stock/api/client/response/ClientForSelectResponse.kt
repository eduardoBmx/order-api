package br.com.lamour.stock.api.client.response

import java.math.BigInteger

data class ClientForSelectResponse(
    val id: BigInteger,
    val name: String
)
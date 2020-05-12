package br.com.lamour.stock.service.client

import br.com.lamour.stock.api.client.request.ClientRequest
import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.client.response.PaginationClientResponse
import java.math.BigInteger

interface ClientService {

    fun createClient(
        clientRequest: ClientRequest
    ): ClientResponse

    fun editClient(
        clientRequest: ClientRequest,
        clientId: BigInteger
    ): ClientResponse

    fun deleteClient(
        clientId: BigInteger
    )

    fun listClient(page: Int, size: Int): PaginationClientResponse
}
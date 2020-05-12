package br.com.lamour.stock.api.client.response

import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.utils.PaginationResponse

data class PaginationClientResponse(
    override val content: List<ClientResponse>,
    override val totalElements: Int,
    override val totalPages: Int,
    override val number: Int
): PaginationResponse<ClientResponse>()
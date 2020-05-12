package br.com.lamour.stock.api.order.response

import br.com.lamour.stock.api.utils.PaginationResponse

data class PaginationOrderResponse(
    override val content: List<OrderResponse>,
    override val totalElements: Int,
    override val totalPages: Int,
    override val number: Int
): PaginationResponse<OrderResponse>() {
}
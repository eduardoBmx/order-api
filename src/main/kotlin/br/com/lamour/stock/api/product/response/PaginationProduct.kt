package br.com.lamour.stock.api.product.response

import br.com.lamour.stock.api.utils.PaginationResponse

data class PaginationProduct(
    override val content: List<ProductResponse>,
    override val totalElements: Int,
    override val totalPages: Int,
    override val number: Int
) : PaginationResponse<ProductResponse>() {
}
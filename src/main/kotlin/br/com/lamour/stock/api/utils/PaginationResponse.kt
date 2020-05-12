package br.com.lamour.stock.api.utils

abstract class PaginationResponse<T> {

    abstract val content: List<T>

    abstract val totalElements: Int

    abstract val totalPages: Int

    abstract val number: Int
}
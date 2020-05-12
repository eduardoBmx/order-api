package br.com.lamour.stock.api.utils.exception

class BadRequestException(
    msg: String
) : RuntimeException(msg)

class NotFoundException(
    msg: String
) : RuntimeException(msg)

class InternalServerError(): RuntimeException("Service Error")
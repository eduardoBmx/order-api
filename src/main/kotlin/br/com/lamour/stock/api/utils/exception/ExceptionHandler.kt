package br.com.lamour.stock.api.utils.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException::class)
    fun exceptionHandlerBadRequest(e: BadRequestException): Map<String, String> =
        mapOf("Error" to e.message.toString())

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun exceptionHandlerNotFound(e: NotFoundException): Map<String, String> =
        mapOf("Error" to e.message.toString())

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError::class)
    fun exceptionHandlerInternalServerError(e: InternalServerError): Map<String, String> =
        mapOf("Error" to e.message.toString())

}
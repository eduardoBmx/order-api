package br.com.lamour.stock.api.client

import br.com.lamour.stock.api.client.request.ClientRequest
import br.com.lamour.stock.api.client.response.ClientForSelectResponse
import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.client.response.PaginationClientResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.math.BigInteger
import javax.validation.Valid

@RequestMapping("/client")
@CrossOrigin
interface ClientApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createClient(
        @Valid @RequestBody clientRequest: ClientRequest
    ): ClientResponse

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun listClients(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationClientResponse

    @PutMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun editProduct(
        @PathVariable("clientId") clientId: BigInteger,
        @Valid @RequestBody clientRequest: ClientRequest
    ): ClientResponse

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    fun deleteProduct(
        @PathVariable("clientId") clientId: BigInteger
    )

    @GetMapping("/select")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    fun getAllForSelect(): List<ClientForSelectResponse>

}
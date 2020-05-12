package br.com.lamour.stock.controller.client

import br.com.lamour.stock.api.client.ClientApi
import br.com.lamour.stock.api.client.request.ClientRequest
import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.client.response.PaginationClientResponse
import br.com.lamour.stock.service.client.ClientService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
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

@Controller
class ClientController(
    private val clientService: ClientService
): ClientApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    override fun createClient(
        @Valid @RequestBody clientRequest: ClientRequest
    ): ClientResponse = clientService.createClient(clientRequest)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    override fun listClients(
        @RequestParam(value = "page", required = true, defaultValue = "1") page: Int,
        @RequestParam(value = "size", required = true, defaultValue = "20") size: Int
    ): PaginationClientResponse = clientService.listClient(page, size)

    @PutMapping("/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    override fun editProduct(
        @PathVariable("clientId") clientId: BigInteger,
        @Valid @RequestBody clientRequest: ClientRequest
    ): ClientResponse = clientService.editClient(clientRequest, clientId)

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    override fun deleteProduct(
        @PathVariable("clientId") clientId: BigInteger
    ) = clientService.deleteClient(clientId)

}
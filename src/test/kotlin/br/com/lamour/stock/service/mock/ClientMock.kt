package br.com.lamour.stock.service.mock

import br.com.lamour.stock.api.client.request.AddressRequest
import br.com.lamour.stock.api.client.request.ClientRequest

fun buildClientRequest() = ClientRequest(
    name = "Eduardo",
    phoneNumber = "33339999",
    email = "eduardo@test.com",
    address = AddressRequest(
        city = "Jaragua do Sul",
        street = "Test",
        complement = "Test",
        cep = "99999999",
        state = "sc",
        district = "JPO",
        number = "110"
    )
)
package br.com.lamour.stock.service.client

import br.com.lamour.stock.api.client.response.AddressResponse
import br.com.lamour.stock.api.client.request.ClientRequest
import br.com.lamour.stock.api.client.response.ClientForSelectResponse
import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.client.response.PaginationClientResponse
import br.com.lamour.stock.repository.entity.Address
import br.com.lamour.stock.repository.entity.Client
import org.springframework.data.domain.Page

fun ClientRequest.toAddressEntity(): Address = Address(
    number = this.address?.number!!,
    cep = this.address.cep!!,
    city = this.address.city!!,
    complement = this.address.complement,
    district = this.address.district!!,
    state = this.address.state!!,
    street = this.address.street!!
)

fun ClientRequest.toClientEntity(address: Address): Client = Client(
    name = this.name!!,
    email = this.email!!,
    phoneNumber = this.phoneNumber,
    address = address
)

fun Client.toResponse(): ClientResponse =
    ClientResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        phoneNumber = this.phoneNumber,
        address = this.address.toResponse()
    )

fun Address.toResponse(): AddressResponse =
    AddressResponse(
        id = this.id,
        street = this.street,
        state = this.state,
        district = this.district,
        complement = this.complement,
        city = this.city,
        cep = this.cep,
        number = this.number
    )

fun Page<Client>.toClientPaginationResponse(): PaginationClientResponse =
    PaginationClientResponse(
        number = this.number,
        totalElements = this.totalElements.toInt(),
        totalPages = this.totalPages,
        content = this.content.map { it.toResponse() }
    )

fun Client.toSelectResponse() = ClientForSelectResponse(
    id = this.id,
    name = this.name
)
package br.com.lamour.stock.service.client

import br.com.lamour.stock.api.client.request.ClientRequest
import br.com.lamour.stock.api.client.response.ClientResponse
import br.com.lamour.stock.api.client.response.PaginationClientResponse
import br.com.lamour.stock.api.utils.exception.NotFoundException
import br.com.lamour.stock.repository.entity.Client
import br.com.lamour.stock.repository.repository.address.AddressRepository
import br.com.lamour.stock.repository.repository.client.ClientRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class ClientServiceImpl(
    private val clientRepository: ClientRepository,
    private val addressRepository: AddressRepository
): ClientService {
    override fun createClient(clientRequest: ClientRequest): ClientResponse {

        val address = addressRepository.save(clientRequest.toAddressEntity())

        return clientRepository.save(clientRequest.toClientEntity(address)).toResponse()
    }

    override fun editClient(clientRequest: ClientRequest, clientId: BigInteger): ClientResponse {
        val client = getClient(clientId)

        addressRepository.save(client.address.copy(
            number = clientRequest.address?.number!!,
            cep = clientRequest.address.cep!!,
            city = clientRequest.address.city!!,
            complement = clientRequest.address.complement,
            district = clientRequest.address.district!!,
            state = clientRequest.address.state!!,
            street = clientRequest.address.street!!
        ))

        return clientRepository.save(client.copy(
            name = clientRequest.name!!,
            phoneNumber = clientRequest.phoneNumber,
            email = clientRequest.email
        )).toResponse()

    }

    override fun deleteClient(clientId: BigInteger) {
        val client = getClient(clientId)
        clientRepository.delete(client)
    }

    override fun listClient(page: Int, size: Int): PaginationClientResponse {
        return clientRepository.findAll(PageRequest.of(page - 1, size)).toClientPaginationResponse()
    }

    private fun getClient(
        clientId: BigInteger
    ): Client = clientRepository.findByIdOrNull(clientId)?: throw NotFoundException("Not found client id $clientId")

}
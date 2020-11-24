package br.com.lamour.stock.service.test

import br.com.lamour.stock.ApplicationTest
import br.com.lamour.stock.api.utils.exception.NotFoundException
import br.com.lamour.stock.service.mock.buildClientRequest
import org.junit.After
import org.junit.Test
import org.springframework.data.repository.findByIdOrNull
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class ClientTest : ApplicationTest() {

    @After
    fun end() {
        clientRepository.deleteAll()
        addressRepository.deleteAll()
    }

    @Test
    fun createClient() {

      val result = clientService.createClient(buildClientRequest())

        assertNotNull(result)
        assertNotNull(result.address)

    }

    @Test
    fun editClient() {

        val clientSave = clientService.createClient(buildClientRequest())

        val result = clientService.editClient(
            buildClientRequest().copy(name = "Robson"),
            clientSave.id!!
        )

        assertEquals(result.name, "Robson")

    }

    @Test
    fun notFoundClient() {

        assertFailsWith<NotFoundException> { clientService.deleteClient(999.toBigInteger()) }

    }

    @Test
    fun deleteClient() {
        val clientSave = clientService.createClient(buildClientRequest())

        clientService.deleteClient(clientSave.id!!)

        val client = clientRepository.findByIdOrNull(clientSave.id!!)
        val address = addressRepository.findByIdOrNull(clientSave.address?.id)

        assertNull(client)
        assertNull(address)
    }

    @Test
    fun listAllClients(){

        clientService.createClient(buildClientRequest())

        val result = clientService.listClient(1,2)

        assertEquals(result.content.size, 1)
        assertEquals(result.totalElements, 1)

    }

    @Test
    fun getClientForSelect() {

        clientService.createClient(buildClientRequest())

        val result = clientService.getForSelect()

        assertEquals(result.size, 1)

    }

}
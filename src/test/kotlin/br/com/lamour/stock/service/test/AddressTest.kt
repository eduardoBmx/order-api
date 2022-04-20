package br.com.lamour.stock.service.test

import br.com.lamour.stock.ApplicationTest
import br.com.lamour.stock.repository.entity.Address
import org.junit.Assert
import org.junit.Test

class AddressTest: ApplicationTest() {

    @Test
    fun test(){

         addressRepository.save(
            Address(
                city = "Jaragua",
                number = "200",
                district = "sc",
                state = "sc",
                cep = "2009999",
                complement = "teste",
                street = "teste"
            )
        )

        val result = addressRepository.findAll()

        Assert.assertEquals(result.size, 1)

    }
}
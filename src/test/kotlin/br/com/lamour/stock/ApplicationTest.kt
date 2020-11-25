package br.com.lamour.stock

import br.com.lamour.stock.repository.repository.address.AddressRepository
import br.com.lamour.stock.repository.repository.client.ClientRepository
import br.com.lamour.stock.service.client.ClientService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
abstract class ApplicationTest {

    @Autowired
    lateinit var addressRepository: AddressRepository

    @Autowired
    lateinit var clientService: ClientService

    @Autowired
    lateinit var clientRepository: ClientRepository

}
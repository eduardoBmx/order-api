package br.com.lamour.stock.repository.repository.client

import br.com.lamour.stock.repository.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface ClientRepository: JpaRepository<Client, BigInteger> {
}
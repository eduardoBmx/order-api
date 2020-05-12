package br.com.lamour.stock.repository.repository.address

import br.com.lamour.stock.repository.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface AddressRepository : JpaRepository<Address, BigInteger> {
}
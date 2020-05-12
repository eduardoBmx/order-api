package br.com.lamour.stock.api.product.response

import br.com.lamour.stock.enum.product.WeightType
import java.math.BigDecimal
import java.math.BigInteger


data class ProductResponse (
    val id: BigInteger? = null,

    val name: String? = null,

    val price: BigDecimal? = null,

    val weightType: WeightType? = null
)
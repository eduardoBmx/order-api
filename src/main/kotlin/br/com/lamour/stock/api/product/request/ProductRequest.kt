package br.com.lamour.stock.api.product.request

import br.com.lamour.stock.enum.product.WeightType
import java.math.BigDecimal
import javax.validation.constraints.NotNull

data class ProductRequest (

    @NotNull
    val name: String? = null,

    @NotNull
    val price: BigDecimal? = null,

    @NotNull
    val weightType: WeightType? = null

)

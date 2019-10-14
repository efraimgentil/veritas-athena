package me.efraimgentil.checker.domain

import java.math.BigDecimal
import java.time.LocalDate

data class DespesaDTO(
        val ano: Int? = null,
        val cnpjCpfFornecedor: String? = null,
        val codDocumento: Int? = null,
        val codLote: Int? = null,
        val codTipoDocumento: Int? = null,
        val dataDocumento: LocalDate? = null,
        val mes: Int? = null,
        val nomeFornecedor: String? = null,
        val numDocumento: String? = null,
        val numRessarcimento: String? = null,
        val parcela: Int? = null,
        val tipoDespesa: String? = null,
        val tipoDocumento: String? = null,
        val urlDocumento: String? = null,
        val valorDocumento: BigDecimal? = null,
        val valorGlosa: BigDecimal? = null,
        val valorLiquido: BigDecimal? = null
)
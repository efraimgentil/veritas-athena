package me.efraimgentil.athena.domain

import me.efraimgentil.athena.domain.dto.ExpenseDTO

data class EventoDespesaDTO(
        val deputadoId : Int,
        val expense : ExpenseDTO
)
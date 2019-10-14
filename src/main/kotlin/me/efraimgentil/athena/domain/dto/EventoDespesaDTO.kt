package me.efraimgentil.athena.domain

import me.efraimgentil.checker.domain.DespesaDTO

data class EventoDespesaDTO(
        val deputadoId : Int,
        val despesa : DespesaDTO
)
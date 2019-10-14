package me.efraimgentil.athena.domain

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.UserDefinedType

@UserDefinedType("type_gabinete")
data class Gabinete(
    @Column val andar: String?,
    @Column val email: String?,
    @Column val nome: String?,
    @Column val predio: String?,
    @Column val sala: String?,
    @Column val telefone: String?
) {
    companion object {
        fun from(dto: GabineteDTO) = Gabinete(
                 dto.andar
                , dto.email
                , dto.nome
                , dto.predio
                , dto.sala
                , dto.telefone)
    }


}
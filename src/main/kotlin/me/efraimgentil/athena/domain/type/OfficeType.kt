package me.efraimgentil.athena.domain.type

import me.efraimgentil.athena.domain.GabineteDTO
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.UserDefinedType

@UserDefinedType("type_office")
data class OfficeType(
        @Column val floor: String?,
        @Column val email: String?,
        @Column val name: String?,
        @Column val building: String?,
        @Column val room: String?,
        @Column val phone: String?
) {
    companion object {
        fun from(dto: GabineteDTO) = OfficeType(
                dto.andar
                , dto.email
                , dto.nome
                , dto.predio
                , dto.sala
                , dto.telefone)
    }


}
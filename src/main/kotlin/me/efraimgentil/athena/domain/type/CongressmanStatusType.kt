package me.efraimgentil.athena.domain.type

import me.efraimgentil.athena.domain.UltimoStatusDTO
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.UserDefinedType

@UserDefinedType("type_congressman_status")
data class CongressmanStatusType(
        val `date`: String,
        @Column("electoral_condition")
        val electoralCondition: String,
        @Column("status_description")
        val statusDescription: String?,
        val office: OfficeType?,
        val id: Int,
        @Column("legislature_id")
        val legislatureId: Int,
        val name: String,
        @Column("electoral_name")
        val electoralName: String,
        @Column("political_party_acronym")
        val politicalPartyAcronym: String,
        @Column("political_party_state")
        val politicalPartyState: String,
        @Column("political_party_uri")
        val politicalPartyUri: String,
        val status: String,
        val uri: String,
        @Column("photo_url")
        val photoUrl: String
) {
        companion object {
                fun from(dto: UltimoStatusDTO?) = if(dto != null) CongressmanStatusType(
                        id = dto.id
                        , legislatureId = dto.idLegislatura
                        , date = dto.data
                        , electoralCondition = dto.condicaoEleitoral
                        , statusDescription = dto.descricaoStatus
                        , office = OfficeType.from(dto.gabinete)
                        , name = dto.nome
                        , electoralName = dto.nomeEleitoral
                        , politicalPartyAcronym = dto.siglaPartido
                        , politicalPartyState = dto.siglaUf
                        , status = dto.situacao
                        , uri = dto.uri
                        , politicalPartyUri = dto.uriPartido
                        , photoUrl = dto.urlFoto
                ) else null
        }
}
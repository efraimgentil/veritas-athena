package me.efraimgentil.athena.domain

import me.efraimgentil.athena.domain.type.CongressmanStatusType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.format.DateTimeFormatter

@Table("congressman")
data class Congressman(
        @PrimaryKey
        val id: Int,
        @Column("identity_document")
        val identityDocument: String,
        @Column("date_of_death")
        var dateOfDeath: String?,
        @Column("date_of_birth")
        var dateOfBirth: String?,
        @Column("education")
        var education: String?,
        @Column("municipality_of_birth")
        var municipalityOfBirth: String?,
        @Column("civil_name")
        var civilName: String?,
        @Column("sex")
        var sex: String?,
        @Column("state_of_birth")
        var stateOfBirth: String?,
        @Column("last_status")
        var lastStatus: CongressmanStatusType?,
        @Column("last_statuses")
        var lastStatuses: List<CongressmanStatusType>?,
        @Column("uri")
        var uri: String?,
        @Column("website_url")
        var websiteUrl: String?
){
        companion object {
                fun from(dto: DeputadoDTO) = Congressman(id = dto.id
                        , identityDocument = dto.cpf
                        , dateOfDeath = dto.dataFalecimento?.format(DateTimeFormatter.ISO_DATE)
                        , dateOfBirth = dto.dataNascimento?.format(DateTimeFormatter.ISO_DATE)
                        , education = dto.escolaridade
                        , municipalityOfBirth = dto.municipioNascimento
                        , civilName = dto.nomeCivil
                        , sex = dto.sexo
                        , stateOfBirth = dto.ufNascimento
                        , lastStatus = CongressmanStatusType.from(dto.ultimoStatus)
                        , lastStatuses = null
                        , uri = dto.uri
                        , websiteUrl = dto.urlWebsite
                )
        }

        fun updateFrom(dto : DeputadoDTO) {
            dateOfDeath = dto.dataFalecimento?.format(DateTimeFormatter.ISO_DATE)
            dateOfBirth = dto.dataNascimento?.format(DateTimeFormatter.ISO_DATE)
            education = dto.escolaridade
            municipalityOfBirth = dto.municipioNascimento
            civilName = dto.nomeCivil
            sex = dto.sexo
            stateOfBirth = dto.ufNascimento
            val newStatus = CongressmanStatusType.from(dto.ultimoStatus)
            lastStatus?.equals(newStatus).let {
               if(lastStatuses == null) {
                       lastStatuses = listOf(lastStatus!!)
               }else{
                       lastStatuses = lastStatuses!!.toMutableList().apply { add(lastStatus!!) }.toList()
               }
               lastStatus = newStatus
            }
            lastStatus = CongressmanStatusType.from(dto.ultimoStatus)
            uri = dto.uri
            websiteUrl = dto.urlWebsite
        }
}

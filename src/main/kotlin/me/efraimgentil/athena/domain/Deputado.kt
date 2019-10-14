package me.efraimgentil.athena.domain

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Table("deputado")
data class Deputado(
        @PrimaryKey
        val id: Int,
        @Column("cpf")
        val cpf: String,
        @Column("data_falecimento")
        var dataFalecimento: String?,
        @Column("data_nascimento")
        var dataNascimento: String?,
        @Column("escolaridade")
        var escolaridade: String?,
        @Column("municipio_nascimento")
        var municipioNascimento: String?,
        @Column("nome_civil")
        var nomeCivil: String?,
        @Column("sexo")
        var sexo: String?,
        @Column("uf_nascimento")
        var ufNascimento: String?,
        @Column("ultimo_status")
        var ultimoStatus: StatusDeputado?,
        @Column("ultimos_status")
        var ultimosStatus: List<StatusDeputado>?,
        @Column("uri")
        var uri: String?,
        @Column("url_website")
        var urlWebsite: String?
){
        companion object {
                fun from(dto: DeputadoDTO) = Deputado(id = dto.id
                        , cpf = dto.cpf
                        , dataFalecimento = dto.dataFalecimento?.format(DateTimeFormatter.ISO_DATE)
                        , dataNascimento = dto.dataNascimento?.format(DateTimeFormatter.ISO_DATE)
                        , escolaridade = dto.escolaridade
                        , municipioNascimento = dto.municipioNascimento
                        , nomeCivil = dto.nomeCivil
                        , sexo = dto.sexo
                        , ufNascimento = dto.ufNascimento
                        , ultimoStatus = StatusDeputado.from(dto.ultimoStatus)
                        , ultimosStatus = null
                        , uri = dto.uri
                        , urlWebsite = dto.urlWebsite
                )
        }

        fun updateFrom(dto : DeputadoDTO) {
            dataFalecimento = dto.dataFalecimento?.format(DateTimeFormatter.ISO_DATE)
            dataNascimento = dto.dataNascimento?.format(DateTimeFormatter.ISO_DATE)
            escolaridade = dto.escolaridade
            municipioNascimento = dto.municipioNascimento
            nomeCivil = dto.nomeCivil
            sexo = dto.sexo
            ufNascimento = dto.ufNascimento
            val newStatus = StatusDeputado.from(dto.ultimoStatus)
            ultimoStatus?.equals(newStatus).let {
               if(ultimosStatus == null) {
                       ultimosStatus = listOf(ultimoStatus!!)
               }else{
                       ultimosStatus = ultimosStatus!!.toMutableList().apply { add(ultimoStatus!!) }.toList()
               }
               ultimoStatus = newStatus
            }
            ultimoStatus = StatusDeputado.from(dto.ultimoStatus)
            uri = dto.uri
            urlWebsite = dto.urlWebsite
        }
}

package me.efraimgentil.athena.domain

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.UserDefinedType

@UserDefinedType("type_status_deputado")
data class StatusDeputado(
        val `data`: String,
        @Column("condicao_eleitoral")
        val condicaoEleitoral: String,
        @Column("descricao_status")
        val descricaoStatus: String?,
        val gabinete: Gabinete?,
        val id: Int,
        @Column("id_legislatura")
        val idLegislatura: Int,
        val nome: String,
        @Column("nome_eleitoral")
        val nomeEleitoral: String,
        @Column("sigla_partido")
        val siglaPartido: String,
        @Column("sigla_uf")
        val siglaUf: String,
        val situacao: String,
        val uri: String,
        @Column("uri_partido")
        val uriPartido: String,
        @Column("url_foto")
        val urlFoto: String
) {
        companion object {
                fun from(dto: UltimoStatusDTO?) = if(dto != null) StatusDeputado(
                        id = dto.id
                        , idLegislatura = dto.idLegislatura
                        , data = dto.data
                        , condicaoEleitoral = dto.condicaoEleitoral
                        , descricaoStatus = dto.descricaoStatus
                        , gabinete = Gabinete.from(dto.gabinete)
                        , nome = dto.nome
                        , nomeEleitoral = dto.nomeEleitoral
                        , siglaPartido = dto.siglaPartido
                        , siglaUf = dto.siglaUf
                        , situacao = dto.situacao
                        , uri = dto.uri
                        , uriPartido = dto.uriPartido
                        , urlFoto = dto.urlFoto
                ) else null
        }
}
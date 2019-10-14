package me.efraimgentil.athena.domain

data class UltimoStatusDTO(
        val `data`: String,
        val condicaoEleitoral: String,
        val descricaoStatus: String?,
        val gabinete: GabineteDTO,
        val id: Int,
        val idLegislatura: Int,
        val nome: String,
        val nomeEleitoral: String,
        val siglaPartido: String,
        val siglaUf: String,
        val situacao: String,
        val uri: String,
        val uriPartido: String,
        val urlFoto: String
)
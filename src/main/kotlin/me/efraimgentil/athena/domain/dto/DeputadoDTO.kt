package me.efraimgentil.athena.domain

import java.time.LocalDate

data class DeputadoDTO(
        val id: Int,
        val cpf: String,
        val dataFalecimento: LocalDate?,
        val dataNascimento: LocalDate?,
        val escolaridade: String?,
        val municipioNascimento: String?,
        val nomeCivil: String?,
        val redeSocial: List<String>?,
        val sexo: String?,
        val ufNascimento: String?,
        val ultimoStatus: UltimoStatusDTO?,
        val uri: String?,
        val urlWebsite: String?
)

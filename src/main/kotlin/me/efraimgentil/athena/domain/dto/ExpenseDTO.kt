package me.efraimgentil.athena.domain.dto

data class ExpenseDTO(
    var ano: Int? = null,
    var cnpjCPF: String? = null,
    var codigoLegislatura: Int? = null,
    var cpf: String? = null,
    var dataEmissao: String? = null,
    var descricao: String? = null,
    var descricaoEspecificacao: String? = null,
    var fornecedor: String? = null,
    var idDeputado: Int? = null,
    var idDocumento: Long? = null,
    var legislatura: Int? = null,
    var lote: String? = null,
    var mes: Int? = null,
    var nomeParlamentar: String? = null,
    var numero: String? = null,
    var numeroCarteiraParlamentar: String? = null,
    var numeroDeputadoID: Int? = null,
    var numeroEspecificacaoSubCota: Int? = null,
    var numeroSubCota: Int? = null,
    var parcela: Int? = null,
    var passageiro: String? = null,
    var ressarcimento: String? = null,
    var restituicao: String? = null,
    var siglaPartido: String? = null,
    var siglaUF: String? = null,
    var tipoDocumento: String? = null,
    var trecho: String? = null,
    var valorDocumento: String? = null,
    var valorGlosa: String? = null,
    var valorLiquido: String? = null
)
package me.efraimgentil.athena.domain.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseDTO(
        @JsonProperty("ano")
        var year: Int? = null,
        @JsonProperty("mes")
        var month: Int? = null,
        @JsonProperty("codigoLegislatura")
        var legislatureCode: Int? = null,
        @JsonProperty("cpf")
        var identityDocument: String? = null,
        @JsonProperty("dataEmissao")
        var issuanceDate: String? = null,
        @JsonProperty("descricao")
        var description: String? = null,
        @JsonProperty("descricaoEspecificacao")
        var specificationDescription: String? = null,
        @JsonProperty("fornecedor")
        var supplier: String? = null,
        @JsonProperty("cnpjCPF")
        var supplierIdentityDocument: String? = null,
        @JsonProperty("idDeputado")
        var congressmanId: Int? = null,
        @JsonProperty("idDocumento")
        var documentId: Long? = null,
        @JsonProperty("legislatura")
        var legislature: Int? = null,
        @JsonProperty("lote")
        var allotment: String? = null,
        @JsonProperty("nomeParlamentar")
        var congressmanName: String? = null,
        @JsonProperty("numero")
        var number: String? = null,
        @JsonProperty("numeroCarteiraParlamentar")
        var numberParliamentarian: String? = null,
        @JsonProperty("numeroDeputadoID")
        var numberCongressmanId: Int? = null,
        @JsonProperty("numeroEspecificacaoSubCota")
        var subQuotaSpecNumber: Int? = null,
        @JsonProperty("numeroSubCota")
        var subQuotaNumber: Int? = null,
        @JsonProperty("parcela")
        var parcel: Int? = null,
        @JsonProperty("passageiro")
        var passenger: String? = null,
        @JsonProperty("ressarcimento")
        var repayment: String? = null,
        @JsonProperty("restituicao")
        var refund: String? = null,
        @JsonProperty("siglaPartido")
        var politicalPartyAcronym: String? = null,
        @JsonProperty("siglaUF")
        var politicalPartyState: String? = null,
        @JsonProperty("tipoDocumento")
        var documentType: String? = null,
        @JsonProperty("trecho")
        var destination: String? = null,
        @JsonProperty("valorDocumento")
        var documentValue: String? = null,
        @JsonProperty("valorGlosa")
        var glossValue: String? = null,
        @JsonProperty("valorLiquido")
        var netValue: String? = null
)
package me.efraimgentil.athena.domain

import me.efraimgentil.athena.domain.dto.ExpenseDTO
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Table("expense_by_year_month_quota_doc")
data class ExpenseByYearMonthQuotaDoc (
        @PrimaryKeyColumn(name = "congressman_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        val congressmanId: Int,
        @PrimaryKeyColumn(name = "year", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
        val year : Int,
        @PrimaryKeyColumn(name = "month", ordinal = 2, type = PrimaryKeyType.PARTITIONED)
        val month : Int,
        @PrimaryKeyColumn(name = "quota", ordinal = 3, type = PrimaryKeyType.CLUSTERED)
        val quota : Int,
        @PrimaryKeyColumn(name = "document_id", ordinal = 4, type = PrimaryKeyType.CLUSTERED)
        val documentId : Long,
        @Column("datetime")
        val datetime : Instant,
        @Column("allotment")
        val allotment : Int,
        @Column("description")
        val description : String,
        @Column("document_value")
        val documentValue : BigDecimal,
        @Column("gloss_value")
        val glossValue : BigDecimal,
        @Column("net_value")
        val netValue : BigDecimal
) {
        companion object {
                fun from(expenseDTO: ExpenseDTO) = ExpenseByYearMonthQuotaDoc(
                        congressmanId = expenseDTO.congressmanId!!
                        , year = expenseDTO.year!!
                        , month = expenseDTO.month!!
                        , quota = expenseDTO.subQuotaNumber!!
                        , documentId = expenseDTO.documentId!!
                        , datetime = Instant.parse(expenseDTO.issuanceDate!! + "-03:00") //TODO maybe apply some transformation pipeline
                        , allotment = expenseDTO.allotment!!.toInt()
                        , description = expenseDTO.description!!
                        , documentValue = expenseDTO.documentValue!!.toBigDecimal()
                        , glossValue = expenseDTO.glossValue!!.toBigDecimal()
                        , netValue = expenseDTO.netValue!!.toBigDecimal()
                )
        }
}
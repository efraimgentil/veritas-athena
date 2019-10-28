package me.efraimgentil.athena.domain

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant

@Table("congressman_status")
data class CongressmanStatus(
    @PrimaryKeyColumn(name = "congressman_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    val congressmanId: Int,
    @Column("legislature_id")
    val legislatureId: Int,
    @PrimaryKeyColumn(name = "datetime", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    val datetime: Instant,
    @Column("status")
    val status: String,
    @Column("political_party_acronym")
    val politicalPartyAcronym: String
)
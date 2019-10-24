package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.CongressmanStatus
import org.springframework.data.cassandra.core.mapping.MapId
import org.springframework.data.cassandra.repository.MapIdCassandraRepository
import java.time.Instant

interface CongressmanStatusRepository : MapIdCassandraRepository<CongressmanStatus>{
    fun countByCongressmanIdAndDatetime(congressmanId : Int, datetime : Instant) : Long
}
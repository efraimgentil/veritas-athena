package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.ExpenseByYearMonthQuotaDoc
import org.springframework.data.cassandra.repository.MapIdCassandraRepository

interface ExpenseByYearMonthQuotaDocRepository : MapIdCassandraRepository<ExpenseByYearMonthQuotaDoc>
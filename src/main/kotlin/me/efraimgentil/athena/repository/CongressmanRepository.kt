package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Congressman
import org.springframework.data.cassandra.repository.CassandraRepository

interface CongressmanRepository : CassandraRepository<Congressman, Int>
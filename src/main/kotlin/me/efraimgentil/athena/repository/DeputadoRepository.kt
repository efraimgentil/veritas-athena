package me.efraimgentil.athena.repository

import me.efraimgentil.athena.domain.Deputado
import org.springframework.data.cassandra.repository.CassandraRepository

interface DeputadoRepository : CassandraRepository<Deputado, Int>
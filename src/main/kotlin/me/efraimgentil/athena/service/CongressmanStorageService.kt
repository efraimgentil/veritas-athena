package me.efraimgentil.athena.service

import io.micrometer.core.annotation.Timed
import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.domain.CongressmanStatus
import me.efraimgentil.athena.domain.DeputadoDTO
import me.efraimgentil.athena.repository.CongressmanRepository
import me.efraimgentil.athena.repository.CongressmanStatusRepository
import org.springframework.data.cassandra.core.mapping.BasicMapId
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CongressmanStorageService(val congressmanRepository: CongressmanRepository
    , val congressmanStatusRepository: CongressmanStatusRepository){

    @Timed
    fun store(congressmanId : DeputadoDTO){
        val congressman = congressmanRepository.findById(congressmanId.id)
        congressman.ifPresent {
           it.updateFrom(congressmanId)
        }
        congressmanRepository.save(congressman.orElse( Congressman.from(congressmanId) ))
    }

    @Timed
    fun addStatusIfNeeded(congressmanDTO : DeputadoDTO){
        val ultimoStatus = congressmanDTO.ultimoStatus
        val findById = congressmanStatusRepository.findById(BasicMapId
                .id("congressmanId", congressmanDTO.id)
                .with("datetime", Instant.parse(ultimoStatus!!.data + ":00-03:00"))
        )

        if(!findById.isPresent) {
            congressmanStatusRepository.save(CongressmanStatus(
                    congressmanId = congressmanDTO.id
                    , datetime = Instant.parse(ultimoStatus!!.data + ":00-03:00")
                    , legislatureId = ultimoStatus.idLegislatura
                    , status = ultimoStatus.situacao
                    , politicalPartyAcronym = ultimoStatus.siglaPartido
            ))
        }
    }
}


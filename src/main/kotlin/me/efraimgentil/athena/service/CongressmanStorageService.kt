package me.efraimgentil.athena.service

import io.micrometer.core.annotation.Timed
import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.domain.DeputadoDTO
import me.efraimgentil.athena.repository.DeputadoRepository
import org.springframework.stereotype.Service

@Service
class CongressmanStorageService(val deputadoRepository: DeputadoRepository){

    @Timed
    fun store(deputadoDTO : DeputadoDTO){
        val deputado = deputadoRepository.findById(deputadoDTO.id)
        deputado.ifPresent {
           it.updateFrom(deputadoDTO)
        }
        deputadoRepository.save(deputado.orElse( Congressman.from(deputadoDTO) ))
    }
}


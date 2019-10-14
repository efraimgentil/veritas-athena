package me.efraimgentil.athena.service

import io.micrometer.core.annotation.Timed
import me.efraimgentil.athena.domain.Deputado
import me.efraimgentil.athena.domain.DeputadoDTO
import me.efraimgentil.athena.repository.DeputadoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Consumer

@Service
class DeputadoStorageService(val deputadoRepository: DeputadoRepository){

    @Timed
    fun store(deputadoDTO : DeputadoDTO){
        val deputado = deputadoRepository.findById(deputadoDTO.id)
        deputado.ifPresent {
           it.updateFrom(deputadoDTO)
        }
        deputadoRepository.save(deputado.orElse( Deputado.from(deputadoDTO) ))
    }
}


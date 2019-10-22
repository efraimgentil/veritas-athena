package me.efraimgentil.athena.controller

import io.micrometer.core.annotation.Timed
import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.repository.DeputadoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DeputadoController(val deputadoRepository: DeputadoRepository) {

    @Timed("DeputadoController.getDeputados")
    @GetMapping("/deputados")
    fun getDeputados() : List<Congressman> {
        return deputadoRepository.findAll()
    }

    @Timed("DeputadoController.getDeputado")
    @GetMapping("/deputado/{deputadoId}")
    fun getDeputado(@PathVariable("deputadoId") deputadoId : Int) : Congressman? {
        return deputadoRepository.findByIdOrNull(deputadoId)
    }
}
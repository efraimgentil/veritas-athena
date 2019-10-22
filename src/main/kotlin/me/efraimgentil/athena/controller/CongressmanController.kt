package me.efraimgentil.athena.controller

import io.micrometer.core.annotation.Timed
import me.efraimgentil.athena.domain.Congressman
import me.efraimgentil.athena.repository.CongressmanRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CongressmanController(val congressmanRepository: CongressmanRepository) {

    @Timed("CongressmanController.getCongressman")
    @GetMapping("/congressman")
    fun getCongressman() : List<Congressman> {
        return congressmanRepository.findAll()
    }

    @Timed("CongressmanController.getCongressmanById")
    @GetMapping("/congressman/{congressmanId}")
    fun getCongressmanById(@PathVariable("congressmanId") congressmanId : Int) : Congressman? {
        return congressmanRepository.findByIdOrNull(congressmanId)
    }
}
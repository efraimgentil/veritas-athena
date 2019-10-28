package me.efraimgentil.athena.controller

import me.efraimgentil.athena.domain.CongressmanStatus
import me.efraimgentil.athena.repository.CongressmanStatusRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["congressmanStatus"])
class CongressmanStatusController (val congressmanStatusRepository: CongressmanStatusRepository){
    @GetMapping(value = ["" , "/"])
    fun getCongressmanStatus() : List<CongressmanStatus> {
        return congressmanStatusRepository.findAll()
    }
}
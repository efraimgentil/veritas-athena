package me.efraimgentil.athena.controller

import me.efraimgentil.checker.domain.DespesaDTO
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Profile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Profile("local")
@RestController
class TestController(val rabbitTemplate: RabbitTemplate){

    @PostMapping("/publish/deputadoDespesa")
    fun postDeputadoDespesa(@RequestBody message: DespesaDTO): ResponseEntity<String> {
        rabbitTemplate.convertAndSend("deputadoDespesa", "", message)
        return ResponseEntity.ok("Published $message")
    }
}

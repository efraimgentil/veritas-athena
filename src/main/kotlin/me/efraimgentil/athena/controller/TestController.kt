package me.efraimgentil.athena.controller

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Profile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import me.efraimgentil.athena.config.RabbitMQConstants.EXPENSE_TOPIC as EXPENSE_TOPIC
import me.efraimgentil.athena.config.RabbitMQConstants.NO_ROUTING as NO_ROUTING

@Profile("local")
@RestController
@RequestMapping(value = ["/test"])
class TestController(val rabbitTemplate: RabbitTemplate){

    @PostMapping("/publish/expense")
    fun publishExpense(@RequestBody message: HashMap<String,Object>): ResponseEntity<String> {
        rabbitTemplate.convertAndSend(EXPENSE_TOPIC, NO_ROUTING, message)
        return ResponseEntity.ok("Published $message")
    }
}
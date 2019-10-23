package me.efraimgentil.athena.listener

import me.efraimgentil.athena.config.RabbitMQConstants
import me.efraimgentil.athena.domain.DeputadoDTO
import me.efraimgentil.athena.service.CongressmanStorageService
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class CongressmanListener(val congressmanStorageService: CongressmanStorageService) {

    @RabbitListener(queues = [RabbitMQConstants.CONGRESSMAN_STORE_QUEUE])
    fun handleCongressmanStore(congressman : DeputadoDTO){
        //logger.info("Received congressman event: ${congressman}")
        congressmanStorageService.store(congressman)
    }

    @RabbitListener(queues = [RabbitMQConstants.CONGRESSMAN_STATUS_STORE_QUEUE])
    fun handleCongressmanStatusStore(congressman : DeputadoDTO){
        //logger.info("Received congressman event: ${congressman}")
        congressmanStorageService.store(congressman)
    }
}
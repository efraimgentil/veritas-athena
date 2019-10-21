package me.efraimgentil.athena.listener

import me.efraimgentil.athena.config.RabbitMQConstants
import me.efraimgentil.athena.domain.DeputadoDTO
import me.efraimgentil.athena.repository.DeputadoRepository
import me.efraimgentil.athena.service.DeputadoStorageService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RabbitListener(queues = [RabbitMQConstants.CONGRESSMAN_STORE_QUEUE])
class EventoDeputadoListener(val deputadoStorageService: DeputadoStorageService) {

    @RabbitHandler
    fun handle(deputado : DeputadoDTO){
        //logger.info("Received deputado event: ${deputado}")
        deputadoStorageService.store(deputado)
    }

}
package me.efraimgentil.athena.listener

import me.efraimgentil.athena.config.RabbitMQConstants
import me.efraimgentil.athena.domain.dto.ExpenseDTO
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service


@Service
class ExpenseListener {

    @RabbitListener(queues = [RabbitMQConstants.EXPENSE_STORE_QUEUE], errorHandler = "defaultErrorHandler")
    fun handle(expense : ExpenseDTO){
        println("Handle and do something with" + expense)

        throw RuntimeException("something went wrong? will it retry?")
    }
}
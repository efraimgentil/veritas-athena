package me.efraimgentil.athena.listener.exception

import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.listener.api.RabbitListenerErrorHandler
import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException
import org.springframework.stereotype.Component

@Component
class DefaultErrorHandler : RabbitListenerErrorHandler {
    override fun handleError(amqpMessage: Message?, message: org.springframework.messaging.Message<*>?, exception: ListenerExecutionFailedException?): Any {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val value = message!!.headers.getValue("amqp_deliveryTag") as? Long

        if(value!! >= 5L){
            throw AmqpRejectAndDontRequeueException("Retry exhausted" , exception!!.cause)
        }
        return ""
    }

}
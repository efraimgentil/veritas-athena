package me.efraimgentil.athena.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Configuration
import org.springframework.amqp.rabbit.retry.RepublishMessageRecoverer
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.retry.interceptor.RetryInterceptorBuilder
import org.springframework.retry.interceptor.RetryOperationsInterceptor



@Configuration
class RabbitMQConfig {

    @Bean
    fun interceptor(): RetryOperationsInterceptor {
        return RetryInterceptorBuilder.stateless()
                .maxAttempts(5)
                .build()
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory, jsonObjectMapper : ObjectMapper): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = producerJackson2MessageConverter(jsonObjectMapper)
        return rabbitTemplate
    }

    @Bean
    fun producerJackson2MessageConverter(jsonObjectMapper : ObjectMapper): Jackson2JsonMessageConverter {
        return Jackson2JsonMessageConverter(jsonObjectMapper)
    }

}
package me.efraimgentil.athena.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile


@Configuration
@Profile("local")
class LocalRabbitMQConfig {

    @Bean
    fun deputadoDespesaStoreQueue() : Queue {
        return Queue("deputadoDespesaStore", true)
    }

    @Bean
    fun deputadoDespesaTopic() : TopicExchange {
        return TopicExchange("deputadoDespesa" , true , false)
    }

    @Bean
    fun deputadoTopic() : TopicExchange {
        return TopicExchange("deputado" , true , false)
    }

    @Bean
    fun deputadoStore() : Queue {
        return Queue("deputadoStore", true)
    }

    /**
     * Bind the queue deputadoStore to the topic deputado
     */
    @Bean
    fun bindingDeputadoStore(deputadoStore : Queue,
                               deputadoTopic : TopicExchange) : Binding {
        return BindingBuilder.bind(deputadoStore)
                .to(deputadoTopic)
                .with("")
    }

    /**
     * Bind the queue deputadoDespesaStore to the topic deputadoDespesa
     */
    @Bean
    fun bindingDeputadoDespesa(deputadoDespesaStoreQueue : Queue,
                               deputadoDespesaTopic : TopicExchange) : Binding {
        return BindingBuilder.bind(deputadoDespesaStoreQueue)
                .to(deputadoDespesaTopic)
                .with("")
    }
}
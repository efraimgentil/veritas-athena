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
    fun expenseStoreQueue() : Queue {
        return Queue(RabbitMQConstants.EXPENSE_STORE_QUEUE, true)
    }

    @Bean
    fun expenseTopic() : TopicExchange {
        return TopicExchange(RabbitMQConstants.EXPENSE_TOPIC , true , false)
    }

    @Bean
    fun congressmanTopic() : TopicExchange {
        return TopicExchange(RabbitMQConstants.CONGRESSMAN_TOPIC , true , false)
    }

    @Bean
    fun congressmanStoreQueue() : Queue {
        return Queue(RabbitMQConstants.CONGRESSMAN_STORE_QUEUE, true)
    }

    @Bean
    fun congressmanStatusStoreQueue() : Queue {
        return Queue(RabbitMQConstants.CONGRESSMAN_STATUS_STORE_QUEUE, true)
    }

    /**
     * Bind EXPENSE_STORE_QUEUE to EXPENSE_TOPIC
     */
    @Bean
    fun bindingExpenseStoreQueueToExpenseTopic(expenseStoreQueue : Queue,
                               expenseTopic : TopicExchange) : Binding {
        return BindingBuilder.bind(expenseStoreQueue)
                .to(expenseTopic)
                .with(RabbitMQConstants.NO_ROUTING)
    }

    /**
     * Bind CONGRESSMAN_STORE_QUEUE to the CONGRESSMAN_TOPIC
     */
    @Bean
    fun bindingCongressmanStoreQueueToCongressmanTopic(congressmanStoreQueue : Queue,
                                                       congressmanTopic : TopicExchange) : Binding {
        return BindingBuilder.bind(congressmanStoreQueue)
                .to(congressmanTopic)
                .with(RabbitMQConstants.NO_ROUTING)
    }

    /**
     * Bind CONGRESSMAN_STORE_QUEUE to the CONGRESSMAN_TOPIC
     */
    @Bean
    fun bindingCongressmanStatusStoreQueueToCongressmanTopic(congressmanStatusStoreQueue : Queue,
                                                       congressmanTopic : TopicExchange) : Binding {
        return BindingBuilder.bind(congressmanStatusStoreQueue)
                .to(congressmanTopic)
                .with(RabbitMQConstants.NO_ROUTING)
    }
}
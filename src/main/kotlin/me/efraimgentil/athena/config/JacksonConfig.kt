package me.efraimgentil.checker.config

import com.fasterxml.jackson.datatype.jsr310.JSR310Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate

@Configuration
class JacksonConfig {

    @Bean
    fun kotlinModule() : KotlinModule{
        return KotlinModule()
    }

    @Bean
    fun javaTimeModule() : JavaTimeModule{
        val javaTimeModule = JavaTimeModule()
        javaTimeModule.addSerializer(LocalDateSerializer.INSTANCE)
        return javaTimeModule
    }
}

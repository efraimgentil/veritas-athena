package me.efraimgentil.athena.config

import io.micrometer.core.aop.TimedAspect
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
class MetricsConfig {

    @Bean
    fun timedAspect(meterRegistry : MeterRegistry) : TimedAspect {
        return TimedAspect(meterRegistry)
    }
}
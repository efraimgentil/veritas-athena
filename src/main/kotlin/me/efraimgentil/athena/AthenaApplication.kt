package me.efraimgentil.athena

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AthenaApplication

fun main(args: Array<String>) {
	runApplication<AthenaApplication>(*args)
}

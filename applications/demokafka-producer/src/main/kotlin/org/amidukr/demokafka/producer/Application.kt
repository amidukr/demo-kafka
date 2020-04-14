package org.amidukr.demokafka.producer

import org.amidukr.demokafka.producer.controller.SendDemoMessageController
import org.amidukr.demokafka.producer.service.SendDemoMessageService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

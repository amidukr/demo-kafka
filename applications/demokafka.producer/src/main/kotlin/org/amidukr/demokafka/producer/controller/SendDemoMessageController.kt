package org.amidukr.demokafka.producer.controller

import org.amidukr.demokafka.producer.service.SendDemoMessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SendDemoMessageController {

    @Autowired
    private lateinit var sendDemoMessageService: SendDemoMessageService;

    @PostMapping("/send/demo-message")
    fun sendDemoMessage(messageContent: String) {
        sendDemoMessageService.sendDemoMessage(messageContent)
    }
}
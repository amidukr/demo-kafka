package org.amidukr.demokafka.producer.controller

import org.amidukr.demokafka.producer.service.SendDemoMessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("demo-message")
class SendDemoMessageController {

    @Autowired
    private lateinit var sendDemoMessageService: SendDemoMessageService;

    @PostMapping("send")
    fun sendDemoMessage(@RequestBody messageContent: String) {
        sendDemoMessageService.sendDemoMessage(messageContent)
    }
}
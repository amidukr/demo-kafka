package org.amidukr.demokafka.producer.service

import org.amidukr.demokafka.producer.properties.KafkaTopicProperties
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
class SendDemoMessageService {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var kafkaTopicProperties: KafkaTopicProperties;

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    private fun generatePartition() = Random().nextInt(kafkaTopicProperties.partitions)
    private fun generateId() = Random().nextInt().toString()

    fun sendDemoMessage(messageContent: String) {
        logger.info("Sending message $messageContent")
        kafkaTemplate.send(kafkaTopicProperties.name, generatePartition(), generateId(), messageContent)
    }
}

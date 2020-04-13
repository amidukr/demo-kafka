package org.amidukr.demokafka.consumer.listener

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.annotation.TopicPartition
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

@Component
class DemoMessageListener {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${demokafka.topic.name}"])
    fun demoMessageHandler(message: String, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partitionId: Int) {
        logger.info("Message retrieved, partitionId = $partitionId, body: $message")
    }
}

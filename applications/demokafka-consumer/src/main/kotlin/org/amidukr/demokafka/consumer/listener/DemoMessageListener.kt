package org.amidukr.demokafka.consumer.listener

import org.amidukr.demokafka.consumer.properties.KafkaTopicProperties
import org.apache.kafka.clients.consumer.OffsetAndMetadata
import org.apache.kafka.common.TopicPartition
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.listener.ConsumerSeekAware
import org.springframework.kafka.listener.KafkaMessageListenerContainer
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.lang.Exception
import java.util.*

@Component
class DemoMessageListener : ConsumerSeekAware {
    private val logger = LoggerFactory.getLogger(javaClass)

    private lateinit var consumerSeekCallback: ConsumerSeekAware.ConsumerSeekCallback

    private val instanceHash = Random().nextInt();

    @Autowired
    private lateinit var kafkaTopicProperties: KafkaTopicProperties;
    
    @KafkaListener(topics = ["\${demokafka.topic.name}"])
    fun demoMessageHandler(message: String, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partitionId: Int) {
        logger.info("Message retrieved, instanceHash = $instanceHash, partitionId = $partitionId, body: $message")
    }

    override fun registerSeekCallback(callback: ConsumerSeekAware.ConsumerSeekCallback?) {
        this.consumerSeekCallback = callback!!;
    }

    fun seekToBeginning() {
        (0 until kafkaTopicProperties.partitions)
                .forEach { consumerSeekCallback.seekToBeginning(kafkaTopicProperties.name, it) }
    }
}

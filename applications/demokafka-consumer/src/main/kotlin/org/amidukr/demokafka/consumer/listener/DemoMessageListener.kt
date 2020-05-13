package org.amidukr.demokafka.consumer.listener

import org.amidukr.demokafka.consumer.properties.KafkaTopicProperties
import org.amidukr.demokafka.consumer.service.CosmoMessageStorageService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.listener.ConsumerSeekAware
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component
import java.util.*

@Component
class DemoMessageListener : ConsumerSeekAware {
    private val logger = LoggerFactory.getLogger(javaClass)

    private lateinit var consumerSeekCallback: ConsumerSeekAware.ConsumerSeekCallback

    private val instanceHash = Random().nextInt();

    @Autowired
    private lateinit var kafkaTopicProperties: KafkaTopicProperties;

    @Autowired
    private lateinit var cosmoMessageStorageService: CosmoMessageStorageService;
    
    @KafkaListener(topics = ["\${demokafka.topic.name}"])
    fun demoMessageHandler(message: String, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partitionId: Int) {
        logger.info("Message retrieved, instanceHash = $instanceHash, partitionId = $partitionId, body: $message")
        cosmoMessageStorageService.saveToDb(message, partitionId)
    }

    override fun registerSeekCallback(callback: ConsumerSeekAware.ConsumerSeekCallback?) {
        this.consumerSeekCallback = callback!!;
    }

    fun seekToBeginning() {
        (0 until kafkaTopicProperties.partitions)
                .forEach { consumerSeekCallback.seekToBeginning(kafkaTopicProperties.name, it) }
    }
}

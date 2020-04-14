package org.amidukr.demokafka.consumer.controller;

import org.amidukr.demokafka.consumer.listener.DemoMessageListener
import org.amidukr.demokafka.consumer.properties.KafkaTopicProperties
import org.apache.kafka.clients.consumer.OffsetAndMetadata
import org.apache.kafka.common.TopicPartition
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.listener.ConsumerSeekAware
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ConsumerController {

    @Autowired
    private lateinit var demoMessageListener: DemoMessageListener;

    @PostMapping("demo-message/replay")
    fun replayMessages() {
        demoMessageListener.seekToBeginning();
    }
}


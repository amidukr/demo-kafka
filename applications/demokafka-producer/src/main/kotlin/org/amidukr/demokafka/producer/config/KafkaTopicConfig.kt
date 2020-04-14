package org.amidukr.demokafka.producer.config

import org.amidukr.demokafka.producer.properties.KafkaTopicProperties
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Autowired
    private lateinit var kafkaTopicProperties: KafkaTopicProperties

    @Bean
    fun demoTestTopic(): NewTopic = TopicBuilder.name(kafkaTopicProperties.name)
            .partitions(kafkaTopicProperties.partitions)
            .build()
}

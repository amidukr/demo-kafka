package org.amidukr.demokafka.producer.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties("demokafka.topic")
class KafkaTopicProperties {
    lateinit var name: String
    var partitions: Int = 0
}

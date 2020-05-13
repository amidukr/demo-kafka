package org.amidukr.demokafka.consumer.cosmodb.entity

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey
import org.springframework.data.annotation.Id

@Document(collection = "messages")
class Message {

    @Id
    @PartitionKey
    var uuid: String? = null

    var partitionId: Int? = null

    var payload: String? = null
}

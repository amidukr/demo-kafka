package org.amidukr.demokafka.consumer.cosmodb.repository

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository
import org.amidukr.demokafka.consumer.cosmodb.entity.Message
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CosmosRepository<Message, String>{
}
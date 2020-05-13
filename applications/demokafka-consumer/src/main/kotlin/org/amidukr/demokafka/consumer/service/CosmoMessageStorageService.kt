package org.amidukr.demokafka.consumer.service

import org.amidukr.demokafka.consumer.cosmodb.entity.Message
import org.amidukr.demokafka.consumer.cosmodb.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CosmoMessageStorageService {

    @Autowired
    private lateinit var messageRepository: MessageRepository;

    fun saveToDb(payload: String, partitionId: Int) {
        val entity = Message();

        entity.uuid = UUID.randomUUID().toString();
        entity.partitionId = partitionId;
        entity.payload = payload;

        messageRepository.save(entity);
    }
}

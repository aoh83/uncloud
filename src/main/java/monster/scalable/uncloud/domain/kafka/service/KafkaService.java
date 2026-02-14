package monster.scalable.uncloud.domain.kafka.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class KafkaService {
    @Async
    @TransactionalEventListener
    public void onCreate(Model.CreateTopicRequest topic) {
        // Simulate topic creation logic (e.g., call Kafka AdminClient)
        log.info("Creating Kafka topic: {}", topic.name());
        // In a real implementation, you would interact with Kafka here
    }

    @Async
    @TransactionalEventListener
    public void onUpdate(Model.UpdateTopicRequest topic) {
        // Simulate topic update logic (e.g., call Kafka AdminClient)
        log.info("Updating Kafka topic: {}", topic.name());
        // In a real implementation, you would interact with Kafka here
    }

    @Async
    @TransactionalEventListener
    public void onDelete(Model.DeleteTopicRequest topic) {
        // Simulate topic deletion logic (e.g., call Kafka AdminClient)
        log.info("Deleting Kafka topic: {}", topic.topicName());
        // In a real implementation, you would interact with Kafka here
    }
    
}

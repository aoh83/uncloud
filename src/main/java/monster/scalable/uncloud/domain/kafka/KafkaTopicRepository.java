package monster.scalable.uncloud.domain.kafka;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository for managing Kafka topics.
 */
@Repository
public interface KafkaTopicRepository extends CrudRepository<KafkaTopic, String> {
    
    /**
     * Find a Kafka topic by its name.
     *
     * @param name the name of the topic
     * @return an Optional containing the topic if found
     */
    Optional<KafkaTopic> findByName(String name);
}

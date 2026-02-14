package monster.scalable.uncloud.domain.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import monster.scalable.uncloud.domain.kafka.persistence.KafkaTopicRepository;
import monster.scalable.uncloud.domain.kafka.persistence.model.KafkaTopic;

/**
 * JPA integration tests for KafkaTopicRepository using PostgreSQL testcontainer.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class KafkaTopicRepositoryTest {
    
    @Autowired
    private KafkaTopicRepository topicRepository;

    @BeforeEach
    void setUp() {
        topicRepository.deleteAll();
    }    

    @Test
    void testSaveAndFindByName() {
        KafkaTopic topic = KafkaTopic.builder().name("test-topic").build();
        topicRepository.save(topic);

        Optional<KafkaTopic> foundTopic = topicRepository.findByName("test-topic");
        assertThat(foundTopic).isPresent();
        assertThat(foundTopic.get().name()).isEqualTo("test-topic");
    }
}
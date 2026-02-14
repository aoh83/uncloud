package monster.scalable.uncloud.domain.kafka.persistence.model;

import ch.qos.logback.core.util.Duration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
import monster.scalable.uncloud.domain.kafka.service.KafkaTopicListener;

/**
 * JPA Entity representing a Kafka topic with its configuration.
 */
@Data
@Accessors(fluent = true, chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "kafka_topics")
@EntityListeners(KafkaTopicListener.class)
public class KafkaTopic {
    
    /**
     * Name of the Kafka topic (Primary Key)
     */
    @Id
    @Column(name = "name", nullable = false, length = 255, unique = true)
    @NonNull
    private String name;
    
    /**
     * Number of partitions for this topic
     */
    @Column(name = "partitions", nullable = false)
    @Builder.Default
    private int partitions = 1;
    
    /**
     * Replication factor for this topic
     */
    @Column(name = "replication_factor", nullable = false)
    @Builder.Default
    private short replicationFactor = 2;
    
    /**
     * Retention time in milliseconds (-1 means no limit)
     */
    @Column(name = "retention_ms", nullable = false)
    @Builder.Default
    private long retentionMs = Duration.buildByHours(1).getMilliseconds();
}

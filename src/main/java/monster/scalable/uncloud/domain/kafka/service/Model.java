package monster.scalable.uncloud.domain.kafka.service;

import monster.scalable.uncloud.domain.kafka.persistence.model.KafkaTopic;

public final class Model {
    public record CreateTopicRequest(String name, int partitions, short replicationFactor, long retentionMs) {
        public CreateTopicRequest(KafkaTopic topic) {
            this(topic.name(), topic.partitions(), topic.replicationFactor(), topic.retentionMs());
        }
    }

    public record UpdateTopicRequest(String name, int partitions, short replicationFactor, long retentionMs) {
        public UpdateTopicRequest(KafkaTopic topic) {
            this(topic.name(), topic.partitions(), topic.replicationFactor(), topic.retentionMs());
        }
    }

    public record DeleteTopicRequest(String topicName) {}

    
}

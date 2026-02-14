package monster.scalable.uncloud.domain.kafka.service;

import org.springframework.context.ApplicationEventPublisher;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.RequiredArgsConstructor;
import monster.scalable.uncloud.domain.kafka.persistence.model.KafkaTopic;

@RequiredArgsConstructor
public class KafkaTopicListener {
    private final ApplicationEventPublisher eventPublisher;

    @PostPersist
    public void afterTopicCreated(KafkaTopic entity) {
        eventPublisher.publishEvent(new Model.CreateTopicRequest(entity));
    }

    @PostUpdate
    public void afterTopicUpdated(KafkaTopic entity) {
        eventPublisher.publishEvent(new Model.UpdateTopicRequest(entity));
    }

    @PostRemove
    public void afterTopicRemoved(KafkaTopic entity) {
        eventPublisher.publishEvent(new Model.DeleteTopicRequest(entity.name()));
    }
}

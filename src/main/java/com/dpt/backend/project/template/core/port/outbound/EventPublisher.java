package com.dpt.backend.project.template;

public interface EventPublisher {
    void publishUserCreated(UserCreatedEvent event);
}

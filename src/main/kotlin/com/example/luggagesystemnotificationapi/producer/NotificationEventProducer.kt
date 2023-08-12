package com.example.luggagesystemnotificationapi.producer

import com.example.luggagesystemnotificationapi.domain.event.NotificationEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component


@Component
class NotificationEventProducer(private val kafkaTemplate: KafkaTemplate<String, NotificationEvent>) {

    suspend fun send(@Payload payload: NotificationEvent) {
        val topic = "notificationEvent"
        kafkaTemplate.send(topic,payload)
    }

}
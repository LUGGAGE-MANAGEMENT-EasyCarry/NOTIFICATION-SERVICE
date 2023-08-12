package com.example.luggagesystemnotificationapi.consumer

import com.example.luggagesystemnotificationapi.domain.event.NotificationEvent
import com.example.luggagesystemnotificationapi.service.NotificationTemplateService
import kotlinx.coroutines.reactor.mono
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class NotificationEventConsumer(private val notificationService: NotificationTemplateService) {

    val logger = LoggerFactory.getLogger(NotificationEvent::class.java)

    @KafkaListener(topicPattern = "notificationEvent", groupId = "kafka-consumer")
    fun receive(@Payload payload: NotificationEvent) {
        logger.info("payload $payload ")
    }
}
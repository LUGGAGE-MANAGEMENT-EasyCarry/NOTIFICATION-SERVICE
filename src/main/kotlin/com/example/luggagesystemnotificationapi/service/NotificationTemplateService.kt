package com.example.luggagesystemnotificationapi.service

import com.example.luggagesystemnotificationapi.domain.dto.NotificationTemplateRequest
import com.example.luggagesystemnotificationapi.domain.event.NotificationEvent
import com.example.luggagesystemnotificationapi.mapper.NotificationTemplateResponseMapper
import com.example.luggagesystemnotificationapi.domain.model.NotificationTemplate
import com.example.luggagesystemnotificationapi.producer.NotificationEventProducer
import com.example.luggagesystemnotificationapi.repository.NotificationTemplateRepository
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service


@Service
class NotificationTemplateService(
    private val notificationTemplateRepository: NotificationTemplateRepository, private val javaMailSender: JavaMailSender,
    private val notificationEventProducer: NotificationEventProducer
) {
    suspend fun createNotification(notificationTemplate: NotificationTemplate): NotificationTemplate {
        val notificationEvent = NotificationEvent(notificationTemplate.info, "merhaba")
        notificationEventProducer.send(notificationEvent)
        return notificationTemplateRepository.save(notificationTemplate)
    }

    suspend fun delete(id: String) {
        notificationTemplateRepository.deleteById(id)
    }


    suspend fun processNotification(notificationEvent: NotificationEvent) {
        val data = notificationEvent.data
        println("$data is sending ... wait ")

    }

    suspend fun sendEmail(to: String, subject: String, htmlContent: String) {
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)

        helper.apply {
            setTo(to)
            setSubject(subject)
            setText(htmlContent, false)
        }

        javaMailSender.send(message)
    }

    suspend fun getNotificationById(id: String): NotificationTemplate? {
        return notificationTemplateRepository.findById(id)?.let {
            return it.get()
        }
        throw RuntimeException("notification didnt found")
    }

}


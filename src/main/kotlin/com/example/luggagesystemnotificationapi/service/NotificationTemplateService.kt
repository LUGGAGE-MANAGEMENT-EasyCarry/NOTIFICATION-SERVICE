package com.example.luggagesystemnotificationapi.service

import com.example.luggagesystemnotificationapi.MailService.MailService
import com.example.luggagesystemnotificationapi.domain.event.NotificationEvent

import com.example.luggagesystemnotificationapi.domain.model.NotificationTemplate
import com.example.luggagesystemnotificationapi.producer.NotificationEventProducer
import com.example.luggagesystemnotificationapi.repository.NotificationTemplateRepository
import com.resend.sdk.Resend
import com.resend.sdk.models.operations.SendEmailRequest
import com.resend.sdk.models.operations.SendEmailResponse
import com.resend.sdk.models.shared.Email
import com.resend.sdk.models.shared.Security
import org.springframework.stereotype.Service


@Service
class NotificationTemplateService(
    private val notificationTemplateRepository: NotificationTemplateRepository,
    private val notificationEventProducer: NotificationEventProducer,
    private val mailService: MailService
) {
    suspend fun createNotification(notificationTemplate: NotificationTemplate): NotificationTemplate {
        val nameOfUser = notificationTemplate.info
        mailService.sendWelcomeMail(nameOfUser)
        return notificationTemplateRepository.save(notificationTemplate)
    }

    suspend fun delete(id: String) {
        notificationTemplateRepository.deleteById(id)
    }


    suspend fun processNotification(notificationEvent: NotificationEvent) {
        val data = notificationEvent.data
        println("$data is sending ... wait ")

    }
    /*
        private suspend fun sendMail(): SendEmailResponse {

            val resendBuilder = Resend.builder()
            resendBuilder.setSecurity(Security().withBearerAuth("Bearer re_NA9aRFw5_BrRMu9cfzpUBZfRsd67NnUEq"))
            val resend = resendBuilder.build()
            val sendEmailRequest = SendEmailRequest().apply {
                request = Email().apply {
                    from = "onboarding@resend.dev"
                    html = ""
                    subject = "hello world"
                    text = "secondemail"
                    to = "190706015@st.maltepe.edu.tr"
                }
            }
            return resend.email.sendEmail(sendEmailRequest)

        }*/

    suspend fun getNotificationById(id: String): NotificationTemplate? {
        return notificationTemplateRepository.findById(id)?.let {
            return it.get()
        }
        throw RuntimeException("notification didnt found")
    }

}


package com.example.luggagesystemnotificationapi.configuration

import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.stereotype.Component

@Component
class JavaMailSenderConfig {

    @Bean
    fun javaMailSender(): JavaMailSender {
        val sender = JavaMailSenderImpl()
        with(sender) {
            host = "smtp.gmail.com"
            port = 587
            username = "furkanyaman319@gmail.com"
            password = "hefoyanmqlhjtiyx"

        }
        val props = sender.javaMailProperties

        props["mail.transport.protocol"] = "smtp"
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.debug"] = "true"

        return sender
    }
}
package com.example.luggagesystemnotificationapi.repository

import com.example.luggagesystemnotificationapi.domain.model.NotificationTemplate
import org.springframework.data.mongodb.repository.MongoRepository


interface NotificationTemplateRepository :MongoRepository<NotificationTemplate, String> {

}
package com.example.luggagesystemnotificationapi.domain.model
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
data class NotificationTemplate(@Id val id: String? = null, val  createdAt: LocalDate, val info:String)
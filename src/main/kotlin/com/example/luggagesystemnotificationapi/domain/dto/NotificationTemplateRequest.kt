package com.example.luggagesystemnotificationapi.domain.dto

import java.time.LocalDate

data class NotificationTemplateRequest(val id: String? = null, val  createdAt: LocalDate, val info:String)
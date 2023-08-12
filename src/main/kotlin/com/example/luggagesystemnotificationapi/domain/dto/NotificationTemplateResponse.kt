package com.example.luggagesystemnotificationapi.domain.dto

import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class NotificationTemplateResponse(val id: String? = null, val  createdAt: LocalDate, val info:String)
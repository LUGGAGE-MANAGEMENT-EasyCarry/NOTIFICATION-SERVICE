package com.example.luggagesystemnotificationapi.domain.dto

import java.time.LocalDate

data class NotificationTemplateRequest( val  createdAt: LocalDate, val info:String)
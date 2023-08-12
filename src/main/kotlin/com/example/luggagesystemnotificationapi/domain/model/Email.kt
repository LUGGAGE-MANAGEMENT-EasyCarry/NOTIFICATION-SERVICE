package com.example.luggagesystemnotificationapi.model

import java.util.UUID

data class Email(val id: UUID?=null, val to: String, val subject: String, val  htmlContent: String)

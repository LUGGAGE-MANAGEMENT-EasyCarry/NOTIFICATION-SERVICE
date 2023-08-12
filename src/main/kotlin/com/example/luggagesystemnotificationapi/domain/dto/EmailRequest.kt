package com.example.luggagesystemnotificationapi.domain.dto

data class EmailRequest(val to: String,val subject: String,val  htmlContent: String)
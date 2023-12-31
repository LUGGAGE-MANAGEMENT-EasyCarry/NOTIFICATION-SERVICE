package com.example.luggagesystemnotificationapi.controller

import com.example.luggagesystemnotificationapi.domain.dto.NotificationTemplateRequest
import com.example.luggagesystemnotificationapi.domain.dto.NotificationTemplateResponse

import com.example.luggagesystemnotificationapi.domain.model.NotificationTemplate
import com.example.luggagesystemnotificationapi.mapper.NotificationTemplateResponseMapper
import com.example.luggagesystemnotificationapi.service.NotificationTemplateService

import org.mapstruct.factory.Mappers
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/notifications")
class NotificationTemplateController(private val notificationService: NotificationTemplateService) {
    @PostMapping
    suspend fun create(@RequestBody notificationTemplateRequest: NotificationTemplateRequest): NotificationTemplateResponse {
        val converter = Mappers.getMapper(NotificationTemplateResponseMapper::class.java)
        val notification = notificationService.createNotification(converter.convertDtoToEntity(notificationTemplateRequest))
        return converter.convertEntityToDto(notification)
    }

    @DeleteMapping("/{id}")
    suspend fun deleteNotificationTemplate(@PathVariable id: String) {
        notificationService.delete(id)
    }


    @GetMapping("/{id}")
    suspend fun getNotificationById(@PathVariable id: String): NotificationTemplate? {
        return notificationService.getNotificationById(id)
    }



}
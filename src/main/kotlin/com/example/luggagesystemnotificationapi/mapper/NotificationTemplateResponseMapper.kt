package com.example.luggagesystemnotificationapi.mapper

import com.example.luggagesystemnotificationapi.domain.dto.NotificationTemplateRequest
import com.example.luggagesystemnotificationapi.domain.dto.NotificationTemplateResponse
import com.example.luggagesystemnotificationapi.domain.model.NotificationTemplate
import org.mapstruct.Mapper


@Mapper
interface NotificationTemplateResponseMapper {

     fun convertEntityToDto(notificationTemplate: NotificationTemplate): NotificationTemplateResponse
     fun  convertDtoToEntity(notificationTemplate: NotificationTemplateRequest):NotificationTemplate
}
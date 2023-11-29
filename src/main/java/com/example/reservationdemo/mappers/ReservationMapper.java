package com.example.reservationdemo.mappers;

import com.example.reservationdemo.entites.ReservationEntity;
import com.example.reservationdemo.models.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public ReservationEntity toEntity(ReservationDto dto) {
        var entity = new ReservationEntity();
        entity.setId(dto.getId());
        entity.setEventName(dto.getEventName());
        entity.setReservationType(dto.getReservationType());
        entity.setAttendeeName(dto.getAttendeeName());
        entity.setContactNumber(dto.getContactNumber());
        entity.setReservationTime(dto.getReservationTime());
        entity.setConfirmed(dto.isConfirmed());
        return entity;
    }

    public ReservationDto toDto(ReservationEntity entity) {
        var dto = new ReservationDto();
        dto.setId(entity.getId());
        dto.setEventName(entity.getEventName());
        dto.setReservationType(entity.getReservationType());
        dto.setAttendeeName(entity.getAttendeeName());
        dto.setContactNumber(entity.getContactNumber());
        dto.setReservationTime(entity.getReservationTime());
        dto.setConfirmed(entity.isConfirmed());
        return dto;
    }
}
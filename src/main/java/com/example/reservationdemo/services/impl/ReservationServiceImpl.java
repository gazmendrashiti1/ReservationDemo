package com.example.reservationdemo.services.impl;

import com.example.reservationdemo.entites.ReservationEntity;
import com.example.reservationdemo.mappers.ReservationMapper;
import com.example.reservationdemo.models.ReservationDto;
import com.example.reservationdemo.repositories.ReservationRepository;
import com.example.reservationdemo.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository; // Replace ReservationRepository with the actual repository class for reservations
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository repository, ReservationMapper reservationMapper) {
        this.repository = repository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public void add(ReservationDto reservation) {
        var entity = reservationMapper.toEntity(reservation);
        repository.save(entity);
    }

    @Override
    public void modify(long id, ReservationDto updatedReservation) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        var entity = optionalEntity.get();
        entity.setEventName(updatedReservation.getEventName());
        entity.setReservationType(updatedReservation.getReservationType());
        entity.setAttendeeName(updatedReservation.getAttendeeName());
        entity.setContactNumber(updatedReservation.getContactNumber());
        entity.setReservationTime(updatedReservation.getReservationTime());
        entity.setConfirmed(updatedReservation.isConfirmed());

        repository.save(entity);
    }

    @Override
    public void removeById(long id) {
        repository.deleteById(id);
    }

    @Override
    public ReservationDto findById(long id) {
        var optionalEntity = repository.findById(id);
        if (optionalEntity.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        var entity = optionalEntity.get();
        return reservationMapper.toDto(entity);
    }

    @Override
    public List<ReservationDto> findAll() {
        return repository.findAll().stream().map(reservationMapper::toDto).toList();
    }
}

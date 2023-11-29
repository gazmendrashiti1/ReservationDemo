package com.example.reservationdemo.services;


import com.example.reservationdemo.models.ReservationDto;

import java.util.List;

public interface ReservationService {
    void add(ReservationDto reservation);

    void modify(long id, ReservationDto updatedReservation);

    void removeById(long id);

    ReservationDto findById(long id);

    List<ReservationDto> findAll();
}
package com.example.reservationdemo.controllers;

import com.example.reservationdemo.models.ReservationDto;
import com.example.reservationdemo.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public void addReservation(@RequestBody ReservationDto newReservation) {
        reservationService.add(newReservation);
    }

    @PutMapping("/{id}")
    public void updateReservation(@PathVariable long id, @RequestBody ReservationDto updatedReservation) {
        reservationService.modify(id, updatedReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable long id) {
        reservationService.removeById(id);
    }
}
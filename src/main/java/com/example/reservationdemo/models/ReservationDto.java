package com.example.reservationdemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private long id;
    private String eventName;  // Change this based on the context of the reservation
    private String reservationType;  // Event, Doctor Appointment, etc.
    private String attendeeName;
    private String contactNumber;
    private LocalDateTime reservationTime;
    private boolean confirmed;
}

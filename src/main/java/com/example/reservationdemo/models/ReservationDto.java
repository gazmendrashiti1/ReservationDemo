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
    private String eventName;
    private String reservationType;
    private String attendeeName;
    private String contactNumber;
    private LocalDateTime reservationTime;
    private boolean confirmed;
}

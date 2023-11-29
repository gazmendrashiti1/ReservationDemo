package com.example.reservationdemo.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "reservation_type")
    private String reservationType;

    @Column(name = "attendee_name")
    private String attendeeName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "reservation_time")
    private LocalDateTime reservationTime;

    @Column(name = "confirmed")
    private boolean confirmed;
}

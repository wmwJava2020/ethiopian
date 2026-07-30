package com.xpo.ticketingservice.entity;

import com.xpo.common.shared.AirportCodeEnum;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketNumberEntity {

    @Id
    @Column(name = "ticket_id", length = 25, updatable = false, nullable = false)
    private String ticketId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AirportCodeEnum departureAirport;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AirportCodeEnum arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @Column(nullable = false)
    private String seatClass;

    @Column(nullable = false)
    private int passengerCount;

    @Column(nullable = false)
    private String ticketStatus;

    @Column(updatable = false)
    private LocalDateTime issuedAt;

    @PrePersist
    public void prePersist() {
        this.issuedAt     = LocalDateTime.now();
        this.ticketStatus = "ISSUED";
    }
}

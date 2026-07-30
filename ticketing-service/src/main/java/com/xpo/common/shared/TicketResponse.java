package com.xpo.common.shared;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private String        ticketNumber;
    private String        ticketStatus;
    private String        firstName;
    private String        lastName;
    private String        email;
    private String        phoneNumber;
    private String        departureAirportCode;
    private String        departureAirportName;
    private String        arrivalAirportCode;
    private String        arrivalAirportName;
    private LocalDateTime departureDate;
    private String        seatClass;
    private LocalDateTime issuedAt;
}

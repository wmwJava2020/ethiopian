package com.xpo.common.shared;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TicketRequest {
    private String        email;
    private String        departureAirportCode;
    private String        arrivalAirportCode;
    private LocalDateTime departureDate;
    private String        seatClass;
    private int           passengerCount;
}

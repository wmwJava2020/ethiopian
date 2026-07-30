package com.xpo.booking.dto;

import lombok.Data;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * DTO for incoming booking request.
 * firstName and lastName are NOT required here —
 * they come from the Customer module via email lookup.
 */
@Data
public class BookingRequest {
    private String email;
    private String phoneNumber;
    private String source;
    private String destination;
}

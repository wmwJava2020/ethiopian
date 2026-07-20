package com.xpo.booking.dto;

import jakarta.persistence.Column;
import lombok.Data;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 12:47 PM
 */

@Data
public class BookingRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String source;
    private String destination;
}

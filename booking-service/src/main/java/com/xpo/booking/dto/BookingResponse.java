package com.xpo.booking.dto;

import com.xpo.booking.utility.Destination;
import com.xpo.booking.utility.Source;
import com.xpo.booking.utility.Status;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Clean DTO — no JPA annotations.
 * Populated from saved Booking entity by BookingMapper.
 */
@Data
public class BookingResponse {
    private String        bookingId;
    private String        firstName;
    private String        lastName;
    private LocalDateTime createdAt;
    private Status        status;
    private Source        source;
    private Destination   destination;
}

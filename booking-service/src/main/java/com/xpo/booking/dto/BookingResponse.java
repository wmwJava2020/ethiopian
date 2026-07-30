package com.xpo.booking.dto;

import com.xpo.booking.utility.Destination;
import com.xpo.booking.utility.Source;
<<<<<<< HEAD
import com.xpo.booking.utility.Status;
import lombok.Data;
import java.time.LocalDateTime;
=======
//import com.xpo.booking.utility.StartAT;
import com.xpo.booking.utility.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9

/**
 * Author: Wondafrash
 * Date: 7/20/2026
<<<<<<< HEAD
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
=======
 * Time: 12:47 PM
 */
@Data
public class BookingResponse {

    private String      bookingId;
    private String      firstName;
    private String      lastName;
    private LocalDateTime createdAt;
    private Status      status;
    private Source      source;
    private Destination destination;
/*
    @Id
    @Column(name = "id", length = 8, updatable = false, nullable = false)
    private String bookingId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Enum<Status> status;

    @Column(nullable = false)
    private Enum<Source> source;

    @Column(nullable = false)
    private Enum<Destination>  destination;


    @PrePersist
    public void prePersist() {
        // UUID looks like: 3fa85f64-5717-4562-b3fc-2c963f66afa6
        // substring(0,8)  →  3fa85f64   ← first 8 chars (hex only)
        if (this.bookingId == null) {
            this.bookingId = UUID.randomUUID()
                    .toString()
                    .replace("-", "")   // remove dashes first
                    .substring(0, 8)    // take first 8 characters
                    .toUpperCase();     // optional: "3FA85F64"
        }
        this.createdAt = LocalDateTime.now();
    }

*/
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
}

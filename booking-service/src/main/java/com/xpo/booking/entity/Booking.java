package com.xpo.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 12:29 PM
 */

@Entity
@Table(name = "tbl_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @Column(name = "id", length = 8, updatable = false, nullable = false)
    private String bookingId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String source;
    @Column(nullable = false)
    private String destination;

    @Column(updatable = false)
    private LocalDateTime createdAt;

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
}

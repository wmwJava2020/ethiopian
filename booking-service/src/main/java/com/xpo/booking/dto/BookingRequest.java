package com.xpo.booking.dto;

<<<<<<< HEAD
=======
import jakarta.persistence.Column;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
import lombok.Data;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
<<<<<<< HEAD
 * DTO for incoming booking request.
 * firstName and lastName are NOT required here —
 * they come from the Customer module via email lookup.
 */
@Data
public class BookingRequest {
=======
 * Time: 12:47 PM
 */

@Data
public class BookingRequest {

    private String firstName;
    private String lastName;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
    private String email;
    private String phoneNumber;
    private String source;
    private String destination;
}

package com.xpo.booking.controller;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.service.BookingService;
import com.xpo.booking.utility.BookingException;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9

/**
 * Author: Wondafrash
 * Date: 7/20/2026
<<<<<<< HEAD
 */
@RestController
@RequestMapping("/api/v0/flight/booking")
=======
 * Time: 1:28 PM
 */
@RequestMapping("/api/v0/flight/booking/")
@RestController
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

<<<<<<< HEAD
    @PostMapping("/confirm")
    public ResponseEntity<BookingResponse> confirmBooking(
            @RequestBody BookingRequest bookingRequest) throws BookingException {
        return ResponseEntity.status(201).body(bookingService.confirm(bookingRequest));
=======
    @PostMapping("/confirm/")
    public BookingResponse confirmBooking(@RequestBody BookingRequest bookingRequest)
            throws BookingException {
        return bookingService.confirm(bookingRequest);
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
    }
}

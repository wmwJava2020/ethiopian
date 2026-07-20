package com.xpo.booking.controller;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.service.BookingService;
import com.xpo.booking.utility.BookingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 1:28 PM
 */
@RequestMapping("/api/v0/flight/booking/")
@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/confirm/")
    public BookingResponse confirmBooking(@RequestBody BookingRequest bookingRequest)
            throws BookingException {
        return bookingService.confirm(bookingRequest);
    }
}

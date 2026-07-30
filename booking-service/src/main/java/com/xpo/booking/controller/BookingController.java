package com.xpo.booking.controller;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.service.BookingService;
import com.xpo.booking.utility.BookingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: Wondafrash
 * Date: 7/20/2026
<<<<<<< HEAD
 */
@RestController
@RequestMapping("/api/v0/flight/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/confirm")
    public ResponseEntity<BookingResponse> confirmBooking(
            @RequestBody BookingRequest bookingRequest) throws BookingException {
        return ResponseEntity.status(201).body(bookingService.confirm(bookingRequest));

}}

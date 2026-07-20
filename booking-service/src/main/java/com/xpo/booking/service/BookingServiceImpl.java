package com.xpo.booking.service;

import com.airlines.ethiopian.service.FlightCustomerModule;
import com.xpo.booking.entity.Booking;
import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.repository.BookingRepository;
import com.xpo.booking.utility.*;
import common.shared.dto.CustomerResponse;
import org.springframework.stereotype.Service;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 1:20 PM
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository    bookingRepository;
    private final FlightCustomerModule flightCustomerModule;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FlightCustomerModule flightCustomerModule) {
        this.bookingRepository    = bookingRepository;
        this.flightCustomerModule = flightCustomerModule;
    }

    @Override
    public BookingResponse confirm(BookingRequest request) throws BookingException {

        validateRequest(request);

        if (bookingRepository.existsByEmail(request.getEmail())) {
            throw new BookingException("A booking already exists for this email");
        }

        // Decoupled call to ethiopian airline main module
        CustomerResponse customer;
        try {
            customer = flightCustomerModule.getCustomerByEmail(request.getEmail());
        } catch (common.shared.utility.BookingException e) {
            throw new BookingException("Customer not found: " + e.getMessage());
        }

        System.out.println("Customer returned: " + customer);
        if (customer == null) {
            throw new BookingException("Customer lookup returned null for email: " + request.getEmail());
        }
        System.out.println("FirstName: " + customer.getFirstName());
        System.out.println("LastName:  " + customer.getLastName());

        Booking booking = new Booking();
        booking.setFirstName(customer.getFirstName());
        booking.setLastName(customer.getLastName());
        booking.setEmail(request.getEmail());
        booking.setPhoneNumber(request.getPhoneNumber());
        booking.setDestination(request.getDestination());
        booking.setSource(request.getSource());

        Booking saved = bookingRepository.save(booking);

        BookingResponse response = new BookingResponse();
        response.setBookingId(saved.getBookingId());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setCreatedAt(saved.getCreatedAt());
        response.setStatus(Status.CONFIRMED);


        try {
            response.setDestination(
                    Destination.valueOf(saved.getDestination().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new BookingException(
                    "Unknown destination: " + saved.getDestination()
                            + ". Valid values: ADD, LHR, DCA, LAS, DFW");
        }

        try {
            response.setSource(
                    Source.valueOf(saved.getSource().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new BookingException(
                    "Unknown source: " + saved.getSource()
                            + ". Valid values: ADD, LHR, DCA, LAS, DFW");
        }

        return response;
    }

    private void validateRequest(BookingRequest request) throws BookingException {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new BookingException("Email is required");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().length() < 9) {
            throw new BookingException("Invalid phone number");
        }
        if (request.getSource() == null || request.getDestination() == null) {
            throw new BookingException("Source and destination are required");
        }
        if (request.getSource().equalsIgnoreCase(request.getDestination())) {
            throw new BookingException("Source and destination cannot be the same");
        }
    }
}
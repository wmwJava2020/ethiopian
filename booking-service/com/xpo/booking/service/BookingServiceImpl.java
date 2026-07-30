package com.xpo.booking.service;

import com.airlines.ethiopian.service.FlightCustomerModule;
import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import com.xpo.booking.repository.BookingRepository;
import common.shared.data.utility.BookingException;
import com.xpo.booking.utility.BookingMapper;
import common.shared.data.dto.CustomerResponse;
import org.springframework.stereotype.Service;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 *
 * Orchestrates:
 *   1. Customer lookup  → FlightCustomerModule (Ethiopian main app)
 *   2. Booking persist  → BookingRepository
 *   3. Mapping          → BookingMapper (request + customer → entity → response)
 */
@Service
public class BookingServiceImpl implements com.xpo.booking.service.BookingService {

    private final BookingRepository bookingRepository;
    private final FlightCustomerModule flightCustomerModule;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FlightCustomerModule flightCustomerModule,
                              BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.flightCustomerModule = flightCustomerModule;
        this.bookingMapper = bookingMapper;
    }

    //@Override
    public BookingResponse confirm(BookingRequest request) throws BookingException {

        // Step 1: Validate
        validateRequest(request);

        // Step 2: Duplicate check
        if (bookingRepository.existsByEmail(request.getEmail())) {
            throw new BookingException("A booking already exists for email: " + request.getEmail());
        }

        // Step 3: Fetch customer from Customer module
        CustomerResponse customer;
        try {
            customer = flightCustomerModule.getCustomerByEmail(request.getEmail());
        } catch (BookingException e) {
            throw new BookingException("Customer not found: " + e.getMessage());
        }

        if (customer == null) {
            throw new BookingException("Customer lookup returned null for: " + request.getEmail());
        }

        // Step 4: Map request + customer → entity, save, return response
        Booking booking = bookingMapper.toBooking(request, customer);
        Booking saved = bookingRepository.save(booking);

        return bookingMapper.toBookingResponse(saved);
    }

    private void validateRequest(BookingRequest request) throws BookingException {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new BookingException("Email is required");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().length() < 9) {
            throw new BookingException("Invalid phone number — must be at least 9 digits");
        }
        if (request.getSource() == null || request.getDestination() == null) {
            throw new BookingException("Source and destination are required");
        }
        if (request.getSource().equalsIgnoreCase(request.getDestination())) {
            throw new BookingException("Source and destination cannot be the same");
        }
    }
}

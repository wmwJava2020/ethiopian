package com.xpo.booking.service;

import com.airlines.ethiopian.service.FlightCustomerModule;
<<<<<<< HEAD
import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import com.xpo.booking.repository.BookingRepository;
import com.xpo.booking.utility.BookingException;
import com.xpo.booking.utility.BookingMapper;
=======
import com.xpo.booking.entity.Booking;
import com.xpo.booking.utility.BookingMapper;
import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.repository.BookingRepository;
import com.xpo.booking.utility.*;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
import common.shared.dto.CustomerResponse;
import org.springframework.stereotype.Service;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
<<<<<<< HEAD
 *
 * Orchestrates:
 *   1. Customer lookup  → FlightCustomerModule (Ethiopian main app)
 *   2. Booking persist  → BookingRepository
 *   3. Mapping          → BookingMapper (request + customer → entity → response)
=======
 * Time: 1:20 PM
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository    bookingRepository;
    private final FlightCustomerModule flightCustomerModule;
<<<<<<< HEAD
    private final BookingMapper        bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FlightCustomerModule flightCustomerModule,
                              BookingMapper bookingMapper) {
        this.bookingRepository    = bookingRepository;
        this.flightCustomerModule = flightCustomerModule;
        this.bookingMapper        = bookingMapper;
=======
    private final BookingMapper      bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FlightCustomerModule flightCustomerModule, BookingMapper bookingMapper) {
        this.bookingRepository    = bookingRepository;
        this.flightCustomerModule = flightCustomerModule;
        this.bookingMapper = bookingMapper;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
    }

    @Override
    public BookingResponse confirm(BookingRequest request) throws BookingException {

<<<<<<< HEAD
        // Step 1: Validate
        validateRequest(request);

        // Step 2: Duplicate check
        if (bookingRepository.existsByEmail(request.getEmail())) {
            throw new BookingException("A booking already exists for email: " + request.getEmail());
        }

        // Step 3: Fetch customer from Customer module
=======
        validateRequest(request);

        if (bookingRepository.existsByEmail(request.getEmail())) {
            throw new BookingException("A booking already exists for this email");
        }

        // Decoupled call to ethiopian airline main module
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
        CustomerResponse customer;
        try {
            customer = flightCustomerModule.getCustomerByEmail(request.getEmail());
        } catch (common.shared.utility.BookingException e) {
            throw new BookingException("Customer not found: " + e.getMessage());
        }

        if (customer == null) {
<<<<<<< HEAD
            throw new BookingException("Customer lookup returned null for: " + request.getEmail());
        }

        // Step 4: Map request + customer → entity, save, return response
        Booking booking = bookingMapper.toBooking(request, customer);
        Booking saved   = bookingRepository.save(booking);
        return bookingMapper.toBookingResponse(saved);
=======
            throw new BookingException("Customer lookup returned null for email: " + request.getEmail());
        }

        // Mapper Interface Implementations
        Booking booking = bookingMapper.toBooking(request);

        Booking savedBooking = bookingRepository.save(booking);

        return bookingMapper.toBookingResponse(savedBooking);

        /*
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

         */
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
    }

    private void validateRequest(BookingRequest request) throws BookingException {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            throw new BookingException("Email is required");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().length() < 9) {
<<<<<<< HEAD
            throw new BookingException("Invalid phone number — must be at least 9 digits");
=======
            throw new BookingException("Invalid phone number");
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
        }
        if (request.getSource() == null || request.getDestination() == null) {
            throw new BookingException("Source and destination are required");
        }
        if (request.getSource().equalsIgnoreCase(request.getDestination())) {
            throw new BookingException("Source and destination cannot be the same");
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9

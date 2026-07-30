package com.xpo.ticketingservice.service;

import com.airlines.ethiopian.service.FlightCustomerModule;
import com.xpo.common.shared.*;
import com.xpo.ticketingservice.entity.TicketNumberEntity;
import com.xpo.ticketingservice.repository.TicketRepository;
import common.shared.data.dto.CustomerResponse;
import common.shared.data.utility.BookingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Author: Wondafrash
 * Date: 7/30/2026
 * Customer info  → FlightCustomerModule (Ethiopian main app)
 * Ticket details → TicketRequest fields
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository     ticketRepository;
    private final FlightCustomerModule flightCustomerModule;
    private final AtomicLong           sequence = new AtomicLong(1);

    @Override
    public TicketResponse issueTicket(TicketRequest request) throws TicketException {

        validateRequest(request);

        // Step 1: Get customer info from Customer module
        CustomerResponse customer;
        try {
            customer = flightCustomerModule.getCustomerByEmail(request.getEmail());
        } catch (BookingException e) {
            throw new TicketException("Customer not found: " + e.getMessage());
        }
        if (customer == null) {
            throw new TicketException("Customer not found for: " + request.getEmail());
        }

        // Step 2: Parse airport codes
        AirportCodeEnum departure = parseAirport(request.getDepartureAirportCode(), "departure");
        AirportCodeEnum arrival   = parseAirport(request.getArrivalAirportCode(),   "arrival");
        if (departure == arrival) {
            throw new TicketException("Departure and arrival airports cannot be the same");
        }

        // Step 3: Generate unique ticket number
        String ticketNumber = TicketIdGenerator.generate("ET", sequence.getAndIncrement());

        // Step 4: Build entity — customer info + ticket info combined
        TicketNumberEntity ticket = TicketNumberEntity.builder()
            .ticketId(ticketNumber)
            .firstName(customer.getFirstName())         // ← Customer module
            .lastName(customer.getLastName())           // ← Customer module
            .email(customer.getEmail())                 // ← Customer module
            .phoneNumber(customer.getPhoneNumber())     // ← Customer module
            .departureAirport(departure)                // ← TicketRequest
            .arrivalAirport(arrival)                    // ← TicketRequest
            .departureDate(request.getDepartureDate())  // ← TicketRequest
            .seatClass(request.getSeatClass())          // ← TicketRequest
            .passengerCount(request.getPassengerCount())
            .build();

        TicketNumberEntity saved = ticketRepository.save(ticket);
        log.info("[TICKET] Issued: {}", saved.getTicketId());
        return toResponse(saved);
    }

    @Override
    public TicketResponse getTicket(String ticketId) throws TicketException {
        return toResponse(ticketRepository.findByTicketId(ticketId)
            .orElseThrow(() -> new TicketException("Ticket not found: " + ticketId)));
    }

    @Override
    public List<TicketResponse> getTicketsByEmail(String email) {
        return ticketRepository.findByEmail(email).stream()
            .map(this::toResponse).collect(Collectors.toList());
    }

    @Override
    public TicketResponse cancelTicket(String ticketId) throws TicketException {
        TicketNumberEntity ticket = ticketRepository.findByTicketId(ticketId)
            .orElseThrow(() -> new TicketException("Ticket not found: " + ticketId));
        if ("CANCELLED".equals(ticket.getTicketStatus())) {
            throw new TicketException("Ticket already cancelled: " + ticketId);
        }
        ticket.setTicketStatus("CANCELLED");
        return toResponse(ticketRepository.save(ticket));
    }

    private AirportCodeEnum parseAirport(String code, String type) throws TicketException {
        try {
            return AirportCodeEnum.valueOf(code.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TicketException("Unknown " + type + " airport code: " + code
                + ". Valid: ADD,DFW,JFK,LAX,ORD,ATL,SEA,IAD,LHR,DCA");
        }
    }

    private void validateRequest(TicketRequest request) throws TicketException {
        if (request.getEmail() == null || request.getEmail().isEmpty())
            throw new TicketException("Email is required");
        if (request.getDepartureAirportCode() == null || request.getDepartureAirportCode().isEmpty())
            throw new TicketException("Departure airport code is required");
        if (request.getArrivalAirportCode() == null || request.getArrivalAirportCode().isEmpty())
            throw new TicketException("Arrival airport code is required");
        if (request.getDepartureDate() == null)
            throw new TicketException("Departure date is required");
        if (request.getSeatClass() == null || request.getSeatClass().isEmpty())
            throw new TicketException("Seat class is required: ECONOMY, BUSINESS, FIRST");
        if (request.getPassengerCount() < 1)
            throw new TicketException("Passenger count must be at least 1");
    }

    private TicketResponse toResponse(TicketNumberEntity t) {
        return TicketResponse.builder()
            .ticketNumber(t.getTicketId())
            .ticketStatus(t.getTicketStatus())
            .firstName(t.getFirstName())
            .lastName(t.getLastName())
            .email(t.getEmail())
            .phoneNumber(t.getPhoneNumber())
            .departureAirportCode(t.getDepartureAirport().getCode())
            .departureAirportName(t.getDepartureAirport().getAirportName())
            .arrivalAirportCode(t.getArrivalAirport().getCode())
            .arrivalAirportName(t.getArrivalAirport().getAirportName())
            .departureDate(t.getDepartureDate())
            .seatClass(t.getSeatClass())
            .issuedAt(t.getIssuedAt())
            .build();
    }
}

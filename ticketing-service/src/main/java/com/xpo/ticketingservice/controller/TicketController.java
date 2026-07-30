package com.xpo.ticketingservice.controller;

import com.xpo.common.shared.TicketRequest;
import com.xpo.common.shared.TicketResponse;
import com.xpo.ticketingservice.service.TicketException;
import com.xpo.ticketingservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Wondafrash
 * Date: 7/30/2026
 *
 * POST   /api/v1/tickets/issue              → issue new ticket
 * GET    /api/v1/tickets/{ticketId}          → get by ticket number
 * GET    /api/v1/tickets/passenger/{email}   → get all for passenger
 * DELETE /api/v1/tickets/{ticketId}/cancel   → cancel ticket
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/issue")
    public ResponseEntity<TicketResponse> issueTicket(
            @RequestBody TicketRequest request) throws TicketException {
        return ResponseEntity.status(201).body(ticketService.issueTicket(request));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketResponse> getTicket(
            @PathVariable String ticketId) throws TicketException {
        return ResponseEntity.ok(ticketService.getTicket(ticketId));
    }

    @GetMapping("/passenger/{email}")
    public ResponseEntity<List<TicketResponse>> getByEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(ticketService.getTicketsByEmail(email));
    }

    @DeleteMapping("/{ticketId}/cancel")
    public ResponseEntity<TicketResponse> cancelTicket(
            @PathVariable String ticketId) throws TicketException {
        return ResponseEntity.ok(ticketService.cancelTicket(ticketId));
    }
}

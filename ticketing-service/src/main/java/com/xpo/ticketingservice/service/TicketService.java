package com.xpo.ticketingservice.service;

import com.xpo.common.shared.TicketRequest;
import com.xpo.common.shared.TicketResponse;
import java.util.List;

public interface TicketService {
    TicketResponse issueTicket(TicketRequest request) throws TicketException;
    TicketResponse getTicket(String ticketId) throws TicketException;
    List<TicketResponse> getTicketsByEmail(String email);
    TicketResponse cancelTicket(String ticketId) throws TicketException;
}

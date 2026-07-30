package com.xpo.ticketingservice.repository;

import com.xpo.common.shared.AirportCodeEnum;
import com.xpo.ticketingservice.entity.TicketNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketNumberEntity, String> {
    List<TicketNumberEntity> findByEmail(String email);
    Optional<TicketNumberEntity> findByTicketId(String ticketId);
    boolean existsByEmail(String email);
    List<TicketNumberEntity> findByDepartureAirport(AirportCodeEnum departureAirport);
}

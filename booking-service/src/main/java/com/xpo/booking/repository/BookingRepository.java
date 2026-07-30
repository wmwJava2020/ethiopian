package com.xpo.booking.repository;

import com.xpo.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {
    boolean existsByEmail(String email);
    Optional<Booking> findByEmail(String email);
}

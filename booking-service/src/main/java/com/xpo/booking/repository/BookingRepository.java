package com.xpo.booking.repository;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {

    boolean existsByEmail(String email);

    Optional<Booking> findByEmail(String email);

    //List<Booking> findByFromLocation(String source);

    //List<Booking> findByToLocation(String destination);

    //List<Booking> findByFromLocationAndToLocation(String source, String destination);
}


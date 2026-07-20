package com.xpo.booking.service;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import com.xpo.booking.utility.BookingException;

public interface BookingService {
   BookingResponse confirm(BookingRequest bookingRequest) throws BookingException;
}

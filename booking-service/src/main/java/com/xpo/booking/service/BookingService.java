package com.xpo.booking.service;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import common.shared.data.utility.BookingException;


public interface BookingService {
    BookingResponse confirm(BookingRequest bookingRequest) throws BookingException;

}

package com.xpo.booking.service;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
<<<<<<< HEAD
import com.xpo.booking.utility.BookingException;

public interface BookingService {
    BookingResponse confirm(BookingRequest bookingRequest) throws BookingException;
=======
import com.xpo.booking.entity.Booking;
import com.xpo.booking.utility.BookingException;

public interface BookingService {
   BookingResponse confirm(BookingRequest bookingRequest) throws BookingException;
>>>>>>> cae5ba3932e3961fe7bc98d39ae58878f7aaccd9
}

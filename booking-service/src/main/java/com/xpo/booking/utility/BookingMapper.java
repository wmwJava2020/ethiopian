package com.xpo.booking.utility;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    //Request -> Entity: pin and registeredDate are set by @PrePersist, not from the request
    Booking toBooking(BookingRequest bookingRequest);

    //Entity -> Response: all fields match by name, so this is fully automatic
    BookingResponse  toBookingResponse(Booking booking);

}

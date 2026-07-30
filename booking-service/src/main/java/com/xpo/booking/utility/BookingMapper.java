package com.xpo.booking.utility;

import com.xpo.booking.dto.BookingRequest;
import com.xpo.booking.dto.BookingResponse;
import com.xpo.booking.entity.Booking;
import common.shared.data.dto.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Author: Wondafrash
 * Date: 7/30/2026
 *

 */
@Mapper(componentModel = "spring")
public interface BookingMapper {

    /**
     * Maps BookingRequest → Booking entity.
     * Customer fields and auto-generated fields are ignored here.
     */
    @Mapping(target = "bookingId",  ignore = true)
    @Mapping(target = "createdAt",  ignore = true)
    @Mapping(target = "firstName",  ignore = true)
    @Mapping(target = "lastName",   ignore = true)
    Booking toBooking(BookingRequest request);

    /**
     * Maps Booking entity → BookingResponse DTO.
     * source and destination in entity are String;
     * response expects enum — MapStruct maps String → enum by name automatically.
     */
    BookingResponse toBookingResponse(Booking booking);

    /**
     * Combined mapping: BookingRequest + CustomerResponse → Booking entity.
     * Call this from BookingServiceImpl.
     */
    default Booking toBooking(BookingRequest request, CustomerResponse customer) {
        Booking booking = toBooking(request);
        booking.setFirstName(customer.getFirstName());
        booking.setLastName(customer.getLastName());
        return booking;
    }


@Mapper(componentModel = "spring")
public interface BookingMapper {

    //Request -> Entity: pin and registeredDate are set by @PrePersist, not from the request
    Booking toBooking(BookingRequest bookingRequest);

    //Entity -> Response: all fields match by name, so this is fully automatic
    BookingResponse toBookingResponse(Booking booking);

}
}

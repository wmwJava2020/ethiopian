package com.airlines.ethiopian.service;

import common.shared.dto.CustomerResponse;
import common.shared.utility.BookingException;

public interface FlightCustomerModule {
    CustomerResponse getCustomerByEmail(String email) throws BookingException;
}

package com.airlines.ethiopian.service;

import common.shared.data.dto.CustomerResponse;
import common.shared.data.utility.BookingException;

public interface FlightCustomerModule {
    CustomerResponse getCustomerByEmail(String email) throws BookingException;
}

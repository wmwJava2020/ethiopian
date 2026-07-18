package com.airlines.ethiopian.service;

import common.shared.dto.CustomerRequest;
import common.shared.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:05 PM
 */
public interface Customers {

    ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customer);

}

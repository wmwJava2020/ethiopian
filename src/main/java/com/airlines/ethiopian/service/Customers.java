package com.airlines.ethiopian.service;

import com.airlines.ethiopian.entity.Customer;
import common.shared.dto.CustomerRequest;
import common.shared.dto.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:05 PM
 */
public interface Customers {

    ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest customer);

    Optional<Customer> getCustomerByEmail(String email);
}

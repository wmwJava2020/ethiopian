package com.airlines.ethiopian.service;

import com.airlines.ethiopian.entity.Customer;
import com.airlines.ethiopian.repository.CustomerRepository;
import common.shared.dto.CustomerResponse;
import common.shared.utility.BookingException;
import common.shared.utility.CustomerMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Author: Wondafrash
 * Date: 7/20/2026
 * Time: 2:05 PM
 */

@Service
@Primary
public class EthiopianCustomerModule implements FlightCustomerModule{

    private final CustomerRepository customerRepository;
    private final CustomerMapper     customerMapper;

    public EthiopianCustomerModule(CustomerRepository customerRepository,
                                   CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper     = customerMapper;
    }

    @Override
    public CustomerResponse getCustomerByEmail(String email)
            throws BookingException {

        System.out.println(">>> Looking up email: " + email);

        Customer customer = customerRepository.findCustomerByEmail(email)
                .orElseThrow(() ->
                        new BookingException("Customer not found for email: " + email));

        System.out.println(">>> Customer entity found: " + customer);
        System.out.println(">>> FirstName: " + customer.getFirstName());
        System.out.println(">>> LastName:  " + customer.getLastName());

        CustomerResponse response = customerMapper.toResponse(customer);

        System.out.println(">>> Mapped response: " + response);

        if (response == null) {
            throw new BookingException("Mapper returned null for email: " + email);
        }

        return response;
    }

}

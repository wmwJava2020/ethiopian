package com.airlines.ethiopian.service;

import com.airlines.ethiopian.entity.Customer;
import com.airlines.ethiopian.repository.CustomerRepository;
import common.shared.dto.CustomerRequest;
import common.shared.dto.CustomerResponse;
import common.shared.utility.CustomerMapper;
import common.shared.utility.CustomerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:20 PM
 */
@Service
public class EthiopianCustomers implements Customers{

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;

    public EthiopianCustomers(CustomerRepository repository,
                              CustomerMapper customerMapper) {
        this.repository = repository;
        this.customerMapper = customerMapper;
    }


    public ResponseEntity<CustomerResponse> saveCustomer(CustomerRequest request) {

        Customer customer = customerMapper.toEntity(request);

        Customer saved = repository.save(customer);

        CustomerResponse response = customerMapper.toResponse(saved);

        return ResponseEntity.ok(response);
    }

    public List<CustomerResponse> findCustomersByDestination(String destination) {
        return repository.findCustomerByDestination(destination)
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    public List<CustomerResponse> getCustomersByStatus(String status) {

        CustomerStatus enumStatus = CustomerStatus.valueOf(status.toUpperCase());

        return repository.findCustomerByStatus(enumStatus)
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }
}

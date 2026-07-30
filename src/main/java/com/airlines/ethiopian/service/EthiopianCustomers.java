package com.airlines.ethiopian.service;

import com.airlines.ethiopian.entity.Customer;
import com.airlines.ethiopian.repository.CustomerRepository;
import common.shared.data.dto.CustomerRequest;
import common.shared.data.dto.CustomerResponse;
import common.shared.data.utility.CustomerMapper;
import common.shared.data.utility.CustomerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:20 PM
 */
@Service
public class EthiopianCustomers implements Customers {

    private final CustomerRepository repository;
    private final CustomerMapper customerMapper;

    public EthiopianCustomers(CustomerRepository repository,
                              CustomerMapper customerMapper) {
        this.repository = repository;
        this.customerMapper = customerMapper;
    }


    public ResponseEntity<Customer> saveCustomer(CustomerRequest request) {

        Customer customer = customerMapper.toEntity(request);

        Customer saved = repository.save(customer);

        CustomerResponse response = customerMapper.toResponse(saved);

        return (ResponseEntity<Customer>) ResponseEntity.ok();
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return repository.findCustomerByEmail(email);
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

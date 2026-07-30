package com.airlines.ethiopian.controller;

import com.airlines.ethiopian.entity.Customer;
import com.airlines.ethiopian.service.Customers;
import com.airlines.ethiopian.service.EthiopianCustomers;
import common.shared.dto.CustomerRequest;
import common.shared.dto.CustomerResponse;
import common.shared.utility.CustomerStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:25 PM
 */

@RestController
@RequestMapping("/api/v0/ethiopian/")
public class EthiopianCustomerController {

    private final EthiopianCustomers customers;

    public EthiopianCustomerController(EthiopianCustomers customers) {
        this.customers = customers;
    }

    @PostMapping("/save/customer")
    public ResponseEntity<CustomerResponse> customersSaved(@RequestBody CustomerRequest request) {
        System.out.println("Received: " + request.toString()); // needs toString from @Data — it's there since you have @Data
        return customers.saveCustomer(request);
    }

    @GetMapping("/get/customer/destination")
    public ResponseEntity<List<CustomerResponse>> findCustomerByDestinations(@RequestParam String location) {
        return ResponseEntity.ok(customers.findCustomersByDestination(location));
    }

    @GetMapping("/get/customer/status")
    public ResponseEntity<List<CustomerResponse>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(customers.getCustomersByStatus(status));
    }


}

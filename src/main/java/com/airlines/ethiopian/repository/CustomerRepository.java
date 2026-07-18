package com.airlines.ethiopian.repository;

import com.airlines.ethiopian.entity.Customer;
import common.shared.utility.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:10 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByDestination(String destination);
    List<Customer> findCustomerByStatus(CustomerStatus status);

    @Query("""
    SELECT new common.shared.dto.CustomerResponse(
        c.custId,
        c.custName,
        c.custEmail,
        c.custPhone,
        c.destination,
        c.status,
        c.registeredDate,
        c.pin
    )
    FROM Customer c
    WHERE c.status = :status
""")
    List<Customer> findByStatus(@Param("status") CustomerStatus status);

    @Query("""
    SELECT new common.shared.dto.CustomerResponse(
        c.custId,
        c.custName,
        c.custEmail,
        c.custPhone,
        c.destination,
        c.status,
        c.registeredDate,
        c.pin
    )
    FROM Customer c
    WHERE c.destination = :destination
""")
    List<Customer> findCustomerByDestinations(@Param("destination") String destination);

}

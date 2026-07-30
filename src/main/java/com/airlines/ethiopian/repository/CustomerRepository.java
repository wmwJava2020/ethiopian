package com.airlines.ethiopian.repository;

import com.airlines.ethiopian.entity.Customer;
import common.shared.dto.CustomerResponse;
import common.shared.utility.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:10 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findCustomerByDestination(String destination);
    List<Customer> findCustomerByStatus(CustomerStatus status);

    // ✅ Returns Optional<Customer> — used by EthiopianCustomerModule
    Optional<Customer> findCustomerByEmail(String email);

    // ✅ Returns Optional<CustomerResponse> via JPQL constructor expression
    @Query("""
        SELECT new common.shared.dto.CustomerResponse(
            c.custId, c.firstName, c.lastName, c.email,
            c.phoneNumber, c.destination, c.source,
            c.status, c.registeredDate, c.pin
        )
        FROM Customer c WHERE c.email = :email
    """)
    Optional<CustomerResponse> findByEmail(@Param("email") String email);
    /*
    List<Customer> findCustomerByDestination(String destination);
    List<Customer> findCustomerByStatus(CustomerStatus status);
    CustomerResponse findCustomerByEmail(String email);

    @Query("""
    SELECT new common.shared.dto.CustomerResponse(
        c.custId,
        c.firstName,
        c.lastName,
        c.email,
        c.phoneNumber,
        c.destination,
        c.source,
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
        c.firstName,
        c.lastName,
        c.email,
        c.phoneNumber,
        c.destination,
        c.source,
        c.status,
        c.registeredDate,
        c.pin
    )
    FROM Customer c
    WHERE c.destination = :destination
""")
    List<Customer> findCustomerByDestinations(@Param("destination") String destination);

    @Query("""
    SELECT new common.shared.dto.CustomerResponse(
                 c.custId,
                 c.firstName,
                 c.lastName,
                 c.email,
                 c.phoneNumber,
                 c.destination,
                 c.source,
                 c.status,
                 c.registeredDate,
                 c.pin
    )
    FROM Customer c
    WHERE c.email = :email
""")
    Optional<CustomerResponse> findByEmail(@Param("email") String email);
*/
}

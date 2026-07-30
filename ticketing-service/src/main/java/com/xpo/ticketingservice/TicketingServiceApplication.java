package com.xpo.ticketingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.xpo.ticketingservice",       // ← ticketing service own classes
        "com.airlines.ethiopian",         // ← FlightCustomerModule + EthiopianCustomerModule
        "common.shared"                   // ← CustomerMapper, BookingException
})
public class TicketingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TicketingServiceApplication.class, args);
    }
}

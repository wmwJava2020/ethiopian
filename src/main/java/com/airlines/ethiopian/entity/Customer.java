package com.airlines.ethiopian.entity;

import common.shared.utility.CustomerStatus;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:00 PM
 */
@Data
@Entity
@Table(name = "tbl_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    private String custName;
    private String custEmail;
    private String custPhone;
    private String destination;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private Date registeredDate;
    private int pin;

    @PrePersist
    public void onCreate() {
        this.registeredDate = new Date();
        this.pin = (int) (System.currentTimeMillis() % 10000);
        if (this.status == null) {
            this.status = CustomerStatus.ECONOMY; // pick your default tier
        }
    }
}

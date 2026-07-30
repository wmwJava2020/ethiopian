package common.shared.dto;

import common.shared.utility.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:47 PM
 */

@Getter
@Setter
public class CustomerResponse {
    public CustomerResponse() {}


    private Long custId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String destination;
    private String source;
    private CustomerStatus status;
    private Date registeredDate;
    private int pin;

    public CustomerResponse(Long custId,
                            String firstName,
                            String lastName,
                            String email,
                            String phoneNumber,
                            String destination,
                            String source,
                            CustomerStatus status,
                            Date registeredDate,
                            int pin) {
        this.custId = custId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.destination = destination;
        this.source = source;
        this.status = status;
        this.registeredDate = registeredDate;
        this.pin = pin;
    }
}

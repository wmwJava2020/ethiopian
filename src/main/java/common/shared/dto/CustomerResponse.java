package common.shared.dto;

import common.shared.utility.CustomerStatus;
import lombok.Data;
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
    private String custName;
    private String custEmail;
    private String custPhone;
    private String destination;
    private CustomerStatus status;
    private Date registeredDate;
    private int pin;

    public CustomerResponse(Long custId, String custName, String custEmail, String custPhone, String destination, CustomerStatus status, Date registeredDate, int pin) {
        this.custId = custId;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
        this.destination = destination;
        this.status = status;
        this.registeredDate = registeredDate;
        this.pin = pin;
    }
}

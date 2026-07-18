package common.shared.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Wondafrash
 * Date: 7/18/2026
 * Time: 2:46 PM
 */
@Getter
@Setter
public class CustomerRequest {

    private String custName;
    private String custEmail;
    private String custPhone;
    private String destination;


}

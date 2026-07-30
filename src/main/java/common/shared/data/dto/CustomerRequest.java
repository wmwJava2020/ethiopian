package common.shared.data.dto;

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

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String destination;
    private String source;


}

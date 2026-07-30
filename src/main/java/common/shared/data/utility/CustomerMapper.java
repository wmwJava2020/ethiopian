package common.shared.data.utility;

import com.airlines.ethiopian.entity.Customer;
import common.shared.data.dto.CustomerRequest;
import common.shared.data.dto.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    // Request -> Entity: pin and registeredDate are set by @PrePersist, not from the request
    Customer toEntity(CustomerRequest request);

    // Entity -> Response: all fields match by name, so this is fully automatic
    CustomerResponse toResponse(Customer customer);
}

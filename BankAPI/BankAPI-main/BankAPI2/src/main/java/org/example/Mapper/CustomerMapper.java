package org.example.Mapper;

import org.example.DTO.CustomerDto;
import org.example.Model.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {
    CustomerDto mapToDto(Customer customer);
}

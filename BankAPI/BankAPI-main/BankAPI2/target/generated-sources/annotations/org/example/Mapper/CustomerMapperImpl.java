package org.example.Mapper;

import javax.annotation.processing.Generated;
import org.example.DTO.CustomerDto;
import org.example.Model.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-01T01:28:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto mapToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setName( customer.getName() );
        customerDto.setGender( customer.getGender() );
        customerDto.setAge( customer.getAge() );
        customerDto.setAddress( customer.getAddress() );

        return customerDto;
    }
}

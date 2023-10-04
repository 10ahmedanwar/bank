package org.example.Services;



import org.example.DTO.CustomerDto;
import org.example.Mapper.CustomerMapper;
import org.example.Model.Customer;
import org.example.Repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
   @Autowired
    public CustomerService(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    public CustomerDto addCustomer(Customer customer){
        return customerMapper.mapToDto(customerRepository.save(customer)) ;
    }

    public CustomerDto getCustomerById(Long customerId){

        return customerMapper.mapToDto(customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found")));
    }

}


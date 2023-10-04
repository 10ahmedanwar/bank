package org.example.Controllers;

import org.example.DTO.CustomerDto;
import org.example.Model.Customer;
import org.example.Services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
         customerService.addCustomer(customer);
        return ResponseEntity.ok("customer added successfully");
    }


    @GetMapping("/{id}")
    public CustomerDto getCustomerDetails(Long customerId) {
        return customerService.getCustomerById(customerId);

    }

}

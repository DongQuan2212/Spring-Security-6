package com.example.demo.Controller;


import com.example.demo.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableMethodSecurity
public class CustomerController {
    final private List<Customer> customers = List.of(
            Customer.builder().id("001").name("Bui Le Dong Quan").email("bldq2212@gmail.com").build(),Customer.builder().id("002").name("Bui Le Hai Dang").email("blhd1909@gmail.com").build()
    );

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/customer/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Customer>> getCustomersList() {
        List<Customer> list = this.customers;
        return ResponseEntity.ok(list);
    }
    @GetMapping("/customer/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getId().equals(id)).toList();
        return ResponseEntity.ok(customers.get(0));
    }
}

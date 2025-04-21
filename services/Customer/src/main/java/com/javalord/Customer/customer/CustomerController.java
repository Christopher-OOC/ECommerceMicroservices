package com.javalord.Customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request) {
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping(value = "/exits/{customer-id}")
    public ResponseEntity<Boolean> exitsById(@PathVariable("customer-id") String custometId) {
        return ResponseEntity.ok(customerService.exitsById(custometId));
    }

    @GetMapping(value = "/exits/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String custometId) {
        return ResponseEntity.ok(customerService.findById(custometId));
    }

    @DeleteMapping(value = "/{customer-id}")
    public ResponseEntity<Void> delete(@PathVariable("customer-id") String custometId) {
        customerService.deleteCustomer(custometId);
        return ResponseEntity.accepted().build();
    }
}

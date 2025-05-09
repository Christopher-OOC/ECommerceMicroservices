package com.javalord.Order.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "Customer", url = "${application.config.customerUrl}")
public interface CustomerClient {

    @GetMapping(value = "/{customerId}")
    Optional<CustomerResponse> findCustomerById(@PathVariable("customerId") String customerId);
}

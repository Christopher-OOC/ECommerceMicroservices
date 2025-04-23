package com.javalord.Order.customer;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Customer", url = "${application.config.customerUrl}")
public interface CustomerClient {
}

package com.javalord.Customer.customer;

public record CustomerResponse(String id,
        String firstname,
        String lastname,
        String email,
        Address address) {
}

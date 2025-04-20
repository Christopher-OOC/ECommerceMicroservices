package com.javalord.Customer.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}

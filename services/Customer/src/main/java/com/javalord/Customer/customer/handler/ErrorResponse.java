package com.javalord.Customer.customer.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}

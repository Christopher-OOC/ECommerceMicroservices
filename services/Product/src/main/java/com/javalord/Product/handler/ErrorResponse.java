package com.javalord.Product.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
